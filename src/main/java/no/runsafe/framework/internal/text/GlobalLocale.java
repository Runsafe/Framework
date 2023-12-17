package no.runsafe.framework.internal.text;

import no.runsafe.framework.internal.configuration.FrameworkConfiguration;

public class GlobalLocale
{
	public GlobalLocale(FrameworkConfiguration config)
	{
		defaultLocale = config.getConfigValueAsString("locale.default");
	}

	public String getLocale()
	{
		return defaultLocale;
	}

	private final String defaultLocale;
}
