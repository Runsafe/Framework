package no.runsafe.framework.internal.configuration;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class FrameworkConfiguration extends Holder
{
	public FrameworkConfiguration()
	{
		super(null, null);
		load();
	}

	@SuppressWarnings({"HardcodedFileSeparator", "IOResourceOpenedButNotSafelyClosed"})
	void load()
	{
		File file = new File("runsafe", "config.yml");
		configFile = YamlConfiguration.loadConfiguration(file);
		configFilePath = file.getPath();
		InputStream defaults = getClass().getResourceAsStream("/default.yml");
		if (defaults != null)
		{
			configFile.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defaults)));
			configFile.options().copyDefaults(true);
		}
		save();
	}
}
