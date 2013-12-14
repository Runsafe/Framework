package no.runsafe.framework.internal.loader;

import no.runsafe.framework.api.hook.IFrameworkHook;
import no.runsafe.framework.internal.engine.HookEngine;
import org.picocontainer.Startable;

public class HookLoader implements Startable
{
	public HookLoader()
	{
	}

	@SuppressWarnings("OverloadedVarargsMethod")
	public HookLoader(HookEngine engine, IFrameworkHook... hooks)
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
