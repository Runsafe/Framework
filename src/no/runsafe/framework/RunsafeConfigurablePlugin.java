package no.runsafe.framework;

import no.runsafe.framework.api.IConfigurationFile;
import no.runsafe.framework.features.Configuration;

import java.io.File;
import java.io.InputStream;

/**
 * Base class for a plugin that is configurable
 */
public abstract class RunsafeConfigurablePlugin extends RunsafePlugin implements IConfigurationFile
{
	@Override
	public final String getConfigurationPath()
	{
		return new File(getDataFolder(), "config.yml").getPath();
	}

	@Override
	public final InputStream getDefaultConfiguration()
	{
		return getResource("defaults.yml");
	}

	@Override
	protected void initializePlugin()
	{
		addComponent(Configuration.class);
		super.initializePlugin();
	}
}
