package no.runsafe.framework.api;

import java.io.InputStream;

/**
 * Provides the configuration subsystem with defaults and configuration storage path
 */
public interface IConfigurationFile
{
	String getConfigurationPath();

	InputStream getDefaultConfiguration();
}
