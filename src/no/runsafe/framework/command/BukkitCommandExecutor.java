package no.runsafe.framework.command;

import no.runsafe.framework.command.prepared.IPreparedCommand;
import no.runsafe.framework.output.ChatColour;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.entity.Player;

/**
 * This class sits between bukkit and the command objects, routing the commands through to the framework objects.
 */
public final class BukkitCommandExecutor implements org.bukkit.command.CommandExecutor
{
	public BukkitCommandExecutor(ICommandHandler command, ICommandExecutor console, IOutput logger)
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
	public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args)
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

	private void executeCommand(org.bukkit.command.CommandSender sender, String[] args)
	{
		IPreparedCommand preparedCommand;
		if (sender instanceof Player)
			preparedCommand = this.command.prepare(ObjectWrapper.convert((Player) sender), args);
		else
			preparedCommand = this.command.prepare(console, args);

		String permission = preparedCommand.getRequiredPermission();
		if (permission == null || sender.hasPermission(permission))
		{
			String feedback = preparedCommand.execute();
			if (feedback != null)
				sender.sendMessage(ChatColour.ToMinecraft(feedback));
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

	private final ICommandHandler command;
	private final ICommandExecutor console;
	private final IOutput logger;
}
