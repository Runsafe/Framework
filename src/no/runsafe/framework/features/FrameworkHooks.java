package no.runsafe.framework.features;

import no.runsafe.framework.api.hook.IFrameworkHook;
import no.runsafe.framework.internal.hooks.HookEngine;
import org.picocontainer.Startable;

public class FrameworkHooks implements Startable
{
	public FrameworkHooks(HookEngine engine, IFrameworkHook... hooks)
	{
		engine.hook(hooks);
	}

	/**
	 * This class is startable in order to force pico to create an instance of it.
	 * Since everything is handled in the constructor, these methods are empty.
	 */
	@Override
	public void start()
	{
	}

	/**
	 * This class is startable in order to force pico to create an instance of it.
	 * Since everything is handled in the constructor, these methods are empty.
	 */
	@Override
	public void stop()
	{
	}
}
