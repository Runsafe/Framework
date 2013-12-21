package no.runsafe.framework.internal.text;

import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.ILocalizer;
import no.runsafe.framework.internal.configuration.ConfigurationEngine;
import no.runsafe.framework.internal.text.GlobalLocale;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Localization implements ILocalizer
{
	public Localization(JavaPlugin plugin, GlobalLocale localizer, ConfigurationEngine engine)
	{
		locale = engine.loadConfiguration(new File(plugin.getDataFolder(), localizer.getLocale() + ".yml"));
	}

	@SuppressWarnings("InstanceMethodNamingConvention")
	@Override
	public String _(String value)
	{
		if(locale.getConfigValueAsString(value) == null)
			locale.setConfigValue(value, value);

		return locale.getConfigValueAsString(value);
	}

	private final IConfiguration locale;
}
