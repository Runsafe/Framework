package no.runsafe.framework.internal.hooks;

import no.runsafe.framework.api.hook.*;
import no.runsafe.framework.internal.InjectionPlugin;
import org.picocontainer.DefaultPicoContainer;

import java.util.List;

/**
 * This class handles hooks plugins provide to the framework
 */
public final class HookEngine
{
	public static HookEngine get()
	{
		return InjectionPlugin.getGlobalComponent(HookEngine.class);
	}

	public static <T> List<T> getHooks(Class<T> type)
	{
		return get().hookContainer.getComponents(type);
	}

	public void hook(List<IFrameworkHook> hooks)
	{
		List<Object> components = hookContainer.getComponents();
		for (IFrameworkHook hook : hooks)
			if (!components.contains(hook))
				hookContainer.addComponent(hook);
	}

	private final DefaultPicoContainer hookContainer = new DefaultPicoContainer();

}
