package no.runsafe.framework.internal.text;

import no.runsafe.framework.api.ILocalizer;
import no.runsafe.framework.internal.log.Console;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Localization implements ILocalizer
{
	public Localization(JavaPlugin plugin, GlobalLocale localizer)
	{
		resourceBundle = new File(plugin.getDataFolder(), localizer.getLocale() + ".yml");
		locale = YamlConfiguration.loadConfiguration(resourceBundle);
	}

	@Override
	public String L(String value)
	{
		if (locale.getString(value) == null)
		{
			locale.set(value, value);
			save();
		}
		return locale.getString(value);
	}

	private void save()
	{
		try
		{
			locale.save(resourceBundle);
		}
		catch (IOException e)
		{
			Console.Global().logException(e);
		}
	}

	private final File resourceBundle;
	private final YamlConfiguration locale;
}
