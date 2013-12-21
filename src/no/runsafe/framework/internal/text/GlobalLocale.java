package no.runsafe.framework.internal.text;

import org.bukkit.configuration.file.YamlConfiguration;
import org.picocontainer.Startable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GlobalLocale implements Startable
{
	@Override
	public void start()
	{
		configure();
	}

	@Override
	public void stop()
	{
	}

	public String getLocale()
	{
		return defaultLocale;
	}

	private void configure()
	{
		YamlConfiguration config = loadDefaults(new File("runsafe", "locale.yml"));
		defaultLocale = config.getString("default");
	}

	@SuppressWarnings({"ReturnOfNull", "HardcodedFileSeparator"})
	private YamlConfiguration loadDefaults(File configFile)
	{
		InputStream defaults = getClass().getResourceAsStream("/locale.yml");
		try
		{
			YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
			config.setDefaults(YamlConfiguration.loadConfiguration(defaults));
			config.options().copyDefaults(true);
			config.save(configFile);
			return config;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		finally
		{
			try
			{
				defaults.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
		return null; // Never reached, due to system.exit above.
	}

	private String defaultLocale;
}
