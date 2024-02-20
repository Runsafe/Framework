package no.runsafe.framework.internal.configuration;

import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.IConfigurationFile;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class handles configuration file access
 */
public final class PluginConfiguration extends Holder implements IConfiguration
{
	public PluginConfiguration(IConsole console, IDebug debugger)
	{
		super(debugger, console);
	}

	Boolean load(IConfigurationFile configurationFile)
	{
		String filePath = configurationFile.getConfigurationPath();
		if (filePath == null)
			return false;
		debugger.debugFine("Loading configuration from %s", filePath);
		File file = new File(filePath);

		configFile = YamlConfiguration.loadConfiguration(file);
		configFilePath = filePath;
		InputStream defaults = configurationFile.getDefaultConfiguration();
		if (defaults != null)
		{
			configFile.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defaults)));
			configFile.options().copyDefaults(true);
		}
		save();
		return true;
	}
}
