package no.runsafe.framework;

import no.runsafe.framework.api.IConfigurationFile;

import java.io.InputStream;

/**
 * Base class for a plugin that is configurable
 */
public abstract class RunsafeConfigurablePlugin extends RunsafePlugin implements IConfigurationFile
{
	@Override
	public final String getConfigurationPath()
	{
		return String.format("plugins/%s/config.yml", getName());
	}

	@Override
	public final InputStream getDefaultConfiguration()
	{
		return getResource("defaults.yml");
	}
}
