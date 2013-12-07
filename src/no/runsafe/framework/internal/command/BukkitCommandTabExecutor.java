package no.runsafe.framework.internal.command;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.IDebug;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.ICommandHandler;
import no.runsafe.framework.api.command.IPreparedCommand;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.text.ChatColour;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.craftbukkit.libs.joptsimple.internal.Strings;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 * This class sits between bukkit and the command objects, routing the commands through to the framework objects.
 */
public final class BukkitCommandTabExecutor implements TabExecutor
{
	public BukkitCommandTabExecutor(ICommandHandler command, ICommandExecutor console, IDebug logger)
	{
		this.command = command;
		this.console = console;
		this.logger = logger;
	}

	public String getName()
	{
		return command.getName();
	}

	public ICommandHandler getHandler()
	{
		return command;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (args == null)
			args = new String[0];
		try
		{
			executeCommand(sender, args);
		}
		catch (Exception e)
		{
			logger.logException(e);
			if (sender != null)
				sender.sendMessage(ChatColour.ToMinecraft("&cCommand threw an exception!"));
		}
		return true;
	}

	@Nullable
	@Override
	public List<String> onTabComplete(CommandSender commandSender, Command command, String alias, String[] args)
	{
		logger.debugFine("Handling tabcomplete for command '%s %s'", alias, Strings.join(args, " "));
		Iterable<String> alternatives = tabCompleteCommand(commandSender, args);
		return alternatives == null ? null : ImmutableList.copyOf(alternatives);
	}

	private Iterable<String> tabCompleteCommand(CommandSender sender, String... args)
	{
		IPreparedCommand preparedCommand = preparedCommand(sender, true, args);
		Iterable<String> options = preparedCommand.tabComplete(args);
		logger.debugFine("Tab completion options to return: %s", options);
		return options;
	}

	private void executeCommand(CommandSender sender, String... args)
	{
		IPreparedCommand preparedCommand = preparedCommand(sender, false, args);

		String permission = preparedCommand.getRequiredPermission();
		if (!(sender instanceof Player) || permission == null || sender.hasPermission(permission))
		{
			String feedback = preparedCommand.execute();
			if (feedback != null)
			{
				if (sender instanceof Player)
					sender.sendMessage(ChatColour.ToMinecraft(feedback));
				else
					RunsafeServer.Instance.getDebugger().writeColoured(feedback, Level.INFO);
			}
		}
		else
		{
			sender.sendMessage(
				ChatColour.ToMinecraft(
					String.format("&4You do not have the required permission &c%s&4!", permission)
				)
			);
		}
	}

	private IPreparedCommand preparedCommand(CommandSender sender, boolean skipLast, String... args)
	{
		if (skipLast)
			args = Arrays.copyOfRange(args, 0, args.length - 1);
		return command.prepare(
			sender instanceof Player ? ObjectWrapper.convert((OfflinePlayer) sender) : console,
			args
		);
	}

	private final ICommandHandler command;
	private final ICommandExecutor console;
	private final IDebug logger;
}
