package no.runsafe.framework.internal;

import no.runsafe.framework.api.hook.IFrameworkHook;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.Startable;

/**
 * This class handles hooks plugins provide to the framework
 */
public final class HookEngine implements Startable
{
	public static final DefaultPicoContainer hookContainer = new DefaultPicoContainer();

	/**
	 * This empty constructor has to be here so pico doesn't throw an exception for plugins without hooks
	 */
	public HookEngine()
	{
	}

	/**
	 * This constructor gets fed all framework hooks in the plugin and stores them with the global hooks container.
	 *
	 * @param hooks Framework hooks provided by the plugin
	 */
	public HookEngine(IFrameworkHook[] hooks)
	{
		for (IFrameworkHook hook : hooks)
			hookContainer.addComponent(hook);
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
