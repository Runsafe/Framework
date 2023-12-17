package no.runsafe.framework.features;

import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.hook.IFrameworkHook;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.hooks.HookEngine;
import org.picocontainer.Startable;

import java.util.List;

public class FrameworkHooks implements Startable
{
	public FrameworkHooks(HookEngine engine, IKernel kernel, IConsole console)
	{
		this.engine = engine;
		this.kernel = kernel;
		this.console = console;
	}

	@Override
	public void start()
	{
		List<IFrameworkHook> hooks = kernel.getComponents(IFrameworkHook.class);
		if (hooks == null || hooks.isEmpty())
			console.logError("The plugin has declared it exports framework hooks, but it has none!");
		else
			engine.hook(hooks);
	}

	/**
	 * This class is startable in order to force pico to create an instance of it.
	 * Since everything is handled in the constructor, these methods are empty.
	 */
	@Override
	public void stop()
	{
	}

	private final HookEngine engine;
	private final IKernel kernel;
	private final IConsole console;
}
