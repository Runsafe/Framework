package no.runsafe.framework.internal.command;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.ICommandHandler;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.minecraft.RunsafeConsole;
import org.bukkit.command.PluginCommand;
import org.picocontainer.Startable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the registration of command objects with bukkit.
 */
@SuppressWarnings("OverloadedVarargsMethod")
public final class CommandEngine implements Startable
{
	/**
	 * This is needed for pico to not throw exceptions
	 *
	 * @param plugin The plugin
	 */
	public CommandEngine(@Nonnull RunsafePlugin plugin)
	{
		this(null, plugin, null);
	}

	/**
	 * @param output   The console to output debug information to
	 * @param plugin   The plugin
	 * @param debugger
	 * @param commands The commands provided by the plugin
	 */
	public CommandEngine(@Nullable IConsole output, @Nonnull RunsafePlugin plugin, IDebug debugger, @Nonnull ICommandHandler... commands)
	{
		this.commands = commands;
		this.plugin = plugin;
		this.output = debugger;
		console = new RunsafeConsole(output);
		consoleLog = output;
	}

	/**
	 * Hooks the commands into bukkit when plugin starts
	 */
	@Override
	public void start()
	{
		for (BukkitCommandTabExecutor executor : getCommands())
			hookCommand(plugin.getCommand(executor.getName()), executor);
	}

	@Override
	public void stop()
	{
		for (BukkitCommandTabExecutor executor : getCommands())
			unhookCommand(plugin.getCommand(executor.getName()));
	}

	private void hookCommand(PluginCommand command, BukkitCommandTabExecutor executor)
	{
		assert console != null;
		assert output != null;
		if (command == null)
			console.sendColouredMessage("Command not found: %s - does it exist in plugin.yml?", executor.getName());
		else
		{
			command.setExecutor(executor);
			output.debugFiner("Command handler for %s registered with bukkit.", executor.getName());
		}
	}

	private static void unhookCommand(PluginCommand command)
	{
		command.setExecutor(null);
	}

	private Iterable<BukkitCommandTabExecutor> getCommands()
	{
		if (output == null)
			return ImmutableList.of();

		List<BukkitCommandTabExecutor> handlers = new ArrayList<BukkitCommandTabExecutor>(commands.length);
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
	@Nonnull
	private final RunsafePlugin plugin;
}
