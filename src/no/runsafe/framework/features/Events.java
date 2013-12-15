package no.runsafe.framework.features;

import no.runsafe.framework.internal.event.EventEngine;
import org.picocontainer.Startable;

public class Events implements Startable
{
	public Events(EventEngine engine)
	{
		this.engine = engine;
	}

	@Override
	public void start()
	{
		engine.registerEvents();
	}

	@Override
	public void stop()
	{
	}

	private final EventEngine engine;
}
