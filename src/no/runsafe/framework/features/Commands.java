package no.runsafe.framework.features;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.internal.command.BukkitCommandTabExecutor;
import no.runsafe.framework.internal.command.CommandEngine;
import org.picocontainer.Startable;

public class Commands implements Startable
{
	public Commands(CommandEngine engine, RunsafePlugin plugin)
	{
		this.engine = engine;
		this.plugin = plugin;
	}

	@Override
	public void start()
	{
		for (BukkitCommandTabExecutor executor : engine.getCommands())
			engine.hookCommand(plugin.getCommand(executor.getName()), executor);
	}

	@Override
	public void stop()
	{
		for (BukkitCommandTabExecutor executor : engine.getCommands())
			engine.unhookCommand(plugin.getCommand(executor.getName()));
	}

	private final CommandEngine engine;
	private final RunsafePlugin plugin;
}
