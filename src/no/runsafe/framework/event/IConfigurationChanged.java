package no.runsafe.framework.event;

import no.runsafe.framework.configuration.IConfiguration;

public interface IConfigurationChanged
{
	void OnConfigurationChanged(IConfiguration configuration);
}
