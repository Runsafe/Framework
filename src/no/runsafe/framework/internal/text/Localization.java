package no.runsafe.framework.internal.text;

import no.runsafe.framework.api.ILocalizer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Localization implements ILocalizer
{
	public Localization(JavaPlugin plugin, GlobalLocale localizer)
	{
		locale = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), localizer.getLocale() + ".yml"));
	}

	@SuppressWarnings("InstanceMethodNamingConvention")
	@Override
	public String _(String value)
	{
		if (locale.getString(value) == null)
			locale.set(value, value);

		return locale.getString(value);
	}

	private final YamlConfiguration locale;
}
