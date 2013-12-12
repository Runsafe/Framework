package no.runsafe.framework.internal;

import org.picocontainer.ComponentAdapter;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Startable;

public class PluginEngineComponent implements LifecycleStrategy
{
	@Override
	public void start(Object o)
	{
		if(o instanceof Startable)
			((Startable) o).start();
	}

	@Override
	public void stop(Object o)
	{
		if(o instanceof Startable)
			((Startable) o).stop();
	}

	@Override
	public void dispose(Object o)
	{
	}

	@Override
	public boolean hasLifecycle(Class<?> aClass)
	{
		return Startable.class.isAssignableFrom(aClass);
	}

	@Override
	public boolean isLazy(ComponentAdapter<?> componentAdapter)
	{
		return false;
	}
}
