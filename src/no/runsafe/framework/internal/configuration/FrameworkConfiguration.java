package no.runsafe.framework.internal.configuration;

import org.bukkit.configuration.file.YamlConfiguration;
import org.picocontainer.Startable;

import java.io.File;
import java.io.InputStream;

public class FrameworkConfiguration extends Holder implements Startable
{
	public FrameworkConfiguration()
	{
		super(null, null);
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
			configFile.setDefaults(YamlConfiguration.loadConfiguration(defaults));
			configFile.options().copyDefaults(true);
		}
		save();
	}

	@Override
	public void start()
	{
		load();
	}

	@Override
	public void stop()
	{
	}
}
