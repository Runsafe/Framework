package no.runsafe.framework;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.configuration.IConfigurationFile;

import java.io.InputStream;

public abstract class RunsafeConfigurablePlugin extends RunsafePlugin implements IConfigurationFile
{
	@Override
	public String getConfigurationPath()
	{
		return String.format("plugins/%s/config.yml", getName());
	}

	@Override
	public InputStream getDefaultConfiguration()
	{
		return getResource("defaults.yml");
	}
}
