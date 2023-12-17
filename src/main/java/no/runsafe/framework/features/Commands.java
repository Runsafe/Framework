package no.runsafe.framework.features;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.internal.command.Engine;
import no.runsafe.framework.internal.command.ITabExecutor;
import org.picocontainer.Startable;

public class Commands implements Startable
{
	public Commands(Engine engine, RunsafePlugin plugin)
	{
		this.engine = engine;
		this.plugin = plugin;
	}

	@Override
	public void start()
	{
		for (ITabExecutor executor : engine.getCommands())
			engine.hookCommand(plugin.getCommand(executor.getName()), executor);
	}

	@Override
	public void stop()
	{
		for (ITabExecutor executor : engine.getCommands())
			engine.unhookCommand(plugin.getCommand(executor.getName()));
	}

	private final Engine engine;
	private final RunsafePlugin plugin;
}
