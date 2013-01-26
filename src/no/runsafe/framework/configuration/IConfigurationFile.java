package no.runsafe.framework.configuration;

import java.io.InputStream;

/**
 * Provides the configuration subsystem with defaults and configuration storage path
 */
public interface IConfigurationFile
{
	public String getConfigurationPath();

	public InputStream getDefaultConfiguration();
}
