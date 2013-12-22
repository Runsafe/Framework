package no.runsafe.framework.internal.command;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.ICommandHandler;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.minecraft.RunsafeConsole;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the registration of command objects with bukkit.
 */
public final class Engine
{
	/**
	 * @param output   The console to output debug information to
	 * @param debugger Debug output handler
	 * @param commands The commands provided by the plugin
	 */
	public Engine(@Nullable IConsole output, IDebug debugger, @Nonnull ICommandHandler... commands)
	{
		this.commands = commands;
		this.output = debugger;
		console = new RunsafeConsole(output);
		consoleLog = output;
	}

	public void hookCommand(PluginCommand command, ITabExecutor executor)
	{
		assert console != null;
		if (command == null)
			console.sendColouredMessage("Command not found: %s - does it exist in plugin.yml?", executor.getName());
		else
		{
			command.setExecutor(executor);
			output.debugFiner("Command handler for %s registered with bukkit.", executor.getName());
		}
	}

	public void unhookCommand(PluginCommand command)
	{
		CommandExecutor executor = command.getExecutor();
		command.setExecutor(null);
		if (executor instanceof ITabExecutor)
			output.debugFiner("Command handler for %s unregistered from bukkit.", ((ITabExecutor) executor).getName());
	}

	public Iterable<ITabExecutor> getCommands()
	{
		if (output == null)
			return ImmutableList.of();

		List<ITabExecutor> handlers = new ArrayList<ITabExecutor>(commands.length);
		for (ICommandHandler command : commands)
		{
			command.setConsole(output);
			handlers.add(new BukkitCommandTabExecutor(command, console, output, consoleLog));
		}
		return handlers;
	}

	@Nullable
	private final ICommandExecutor console;
	private final IDebug output;
	private final IConsole consoleLog;
	@Nonnull
	private final ICommandHandler[] commands;
}
