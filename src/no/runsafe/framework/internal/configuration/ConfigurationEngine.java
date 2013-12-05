package no.runsafe.framework.internal.configuration;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.IConfigurationFile;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.event.plugin.IConfigurationChanged;
import org.bukkit.configuration.file.YamlConfiguration;
import org.picocontainer.Startable;

import javax.annotation.Nullable;
import java.io.File;
import java.io.InputStream;

/**
 * This class handles basic configuration features of the plugin
 */
@SuppressWarnings("OverloadedVarargsMethod")
public final class ConfigurationEngine implements Startable
{
	public IConfiguration loadConfiguration(String fileName)
	{
		Configuration config = new Configuration(console);
		File configFile = new File(fileName);
		config.configFilePath = fileName;
		config.configFile = YamlConfiguration.loadConfiguration(configFile);
		return config;
	}

	public IConfiguration loadConfiguration(File configFile)
	{
		Configuration config = new Configuration(console);
		config.configFilePath = configFile.getPath();
		config.configFile = YamlConfiguration.loadConfiguration(configFile);
		return config;
	}

	/**
	 * This is needed for pico to not throw exceptions
	 *
	 * @param plugin The plugin
	 */
	public ConfigurationEngine(RunsafePlugin plugin)
	{
		this(plugin, null, null);
	}

	/**
	 * @param plugin        The plugin
	 * @param configuration The configuration handler class
	 * @param output        Console to write messages to
	 * @param subscribers   Plugin components subscribing to configuration change events
	 */
	public ConfigurationEngine(
		RunsafePlugin plugin,
		Configuration configuration,
		IOutput output, IConfigurationChanged... subscribers)
	{
		console = output;
		this.subscribers = subscribers;
		this.configuration = configuration;
		if (plugin instanceof IConfigurationFile)
		{
			IConfigurationFile provider = (IConfigurationFile) plugin;
			configFilePath = provider.getConfigurationPath();
			configurationFile = provider;
		}
		else
		{
			configFilePath = null;
			configurationFile = null;
		}
	}

	/**
	 * Loads configuration on plugin startup
	 */
	@Override
	public void start()
	{
		load();
	}

	@Override
	public void stop()
	{
	}

	/**
	 * Loads configuration for the plugin from disk
	 */
	void load()
	{
		if (configFilePath == null || configurationFile == null || configuration == null)
			return;

		File configFile = new File(configFilePath);

		configuration.configFile = YamlConfiguration.loadConfiguration(configFile);
		configuration.configFilePath = configFilePath;
		InputStream defaults = configurationFile.getDefaultConfiguration();
		if (defaults != null)
		{
			configuration.configFile.setDefaults(YamlConfiguration.loadConfiguration(defaults));
			configuration.configFile.options().copyDefaults(true);
		}
		configuration.save();
		notifySubscribers();
	}

	/**
	 * Restore plugin configuration to the defaults
	 *
	 * @return Success
	 */
	public boolean restoreToDefaults()
	{
		if (configuration.configFile.getDefaults() != null)
		{
			configuration.configFile.options().copyDefaults(true);
			configuration.save();
			console.logInformation("Configuration restored to defaults.");
			return true;
		}
		return false;
	}

	private void notifySubscribers()
	{
		if (subscribers != null)
		{
			for (IConfigurationChanged sub : subscribers)
			{
				try
				{
					console.debugFiner(
						"Notifying subscriber %s about updated configuration.",
						sub.getClass().getCanonicalName()
					);
					sub.OnConfigurationChanged(configuration);
				}
				catch (Exception e)
				{
					console.logException(e);
				}
			}
			console.outputToConsole(
				String.format("Configuration change notifications sent to %d modules.", subscribers.length)
			);
		}
	}

	private final IConfigurationChanged[] subscribers;
	private final IOutput console;
	private final Configuration configuration;
	@Nullable
	private final String configFilePath;
	@Nullable
	private final IConfigurationFile configurationFile;
}
