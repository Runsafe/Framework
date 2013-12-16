package no.runsafe.framework.features;

import no.runsafe.framework.internal.event.BukkitEventMapper;
import org.picocontainer.Startable;

public class Events implements Startable
{
	public Events(BukkitEventMapper engine)
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

	private final BukkitEventMapper engine;
}
