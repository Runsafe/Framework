package no.runsafe.framework.configuration;

import java.io.InputStream;

public interface IConfigurationFile
{
	public String getConfigurationPath();
	public InputStream getDefaultConfiguration();
}
