package no.runsafe.framework.api.event.plugin;

import no.runsafe.framework.api.IConfiguration;

public interface IConfigurationChanged
{
	void OnConfigurationChanged(IConfiguration configuration);
}
