package no.runsafe.framework.features;

import no.runsafe.framework.internal.configuration.ConfigurationEngine;
import org.picocontainer.Startable;

public class Configuration implements Startable
{
	public Configuration(ConfigurationEngine engine)
	{
		this.engine = engine;
	}

	@Override
	public void start()
	{
		engine.load();
	}

	@Override
	public void stop()
	{
	}

	private final ConfigurationEngine engine;
}
