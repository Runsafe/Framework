package no.runsafe.framework.internal.configuration;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.IConfigurationFile;
import no.runsafe.framework.api.event.plugin.IConfigurationChanged;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;

import java.io.File;
import java.util.ArrayList;

/**
 * This class handles basic configuration features of the plugin
 */
@SuppressWarnings("LocalVariableOfConcreteClass")
public final class ConfigurationEngine
{
	public IConfiguration loadConfiguration(String fileName)
	{
		PluginConfiguration config = new PluginConfiguration(console, debugger);
		config.load(new File(fileName));
		return config;
	}

	public IConfiguration loadConfiguration(File configFile)
	{
		PluginConfiguration config = new PluginConfiguration(console, debugger);
		config.load(configFile);
		return config;
	}

	public IConfiguration getPluginConfiguration()
	{
		return configuration;
	}

	/**
	 * @param plugin        The plugin
	 * @param output        Console to write messages to
	 * @param subscribers   Plugin components subscribing to configuration change events
	 */
	public ConfigurationEngine(IConfigurationFile plugin, IConsole output, IDebug debug, IConfigurationChanged... subscribers)
	{
		this.subscribers = Lists.newArrayList(subscribers);
		console = output;
		debugger = debug;
		configuration = new PluginConfiguration(output, debugger);
		configurationFile = plugin;
	}

	/**
	 * Loads configuration for the plugin from disk
	 */
	public void load()
	{
		configuration.load(configurationFile);
		notifySubscribers();
	}

	/**
	 * Restore plugin configuration to the defaults
	 *
	 * @return Success
	 */
	public boolean restoreToDefaults()
	{
		if (!configuration.reset())
			return false;
		notifySubscribers();
		return true;
	}

	private void notifySubscribers()
	{
		if (subscribers != null)
		{
			for (IConfigurationChanged sub : subscribers)
			{
				try
				{
					debugger.debugFiner(
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
			debugger.debugFine("PluginConfiguration change notifications sent to %d modules.", subscribers.size());
		}
	}

	private final ArrayList<IConfigurationChanged> subscribers;
	private final IConsole console;
	private final IDebug debugger;
	private final PluginConfiguration configuration;
	private final IConfigurationFile configurationFile;
}
