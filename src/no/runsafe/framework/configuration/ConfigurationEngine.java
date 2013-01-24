package no.runsafe.framework.configuration;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.event.IConfigurationChanged;
import no.runsafe.framework.output.IOutput;
import org.bukkit.configuration.file.YamlConfiguration;
import org.picocontainer.Startable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ConfigurationEngine implements Startable
{
	public ConfigurationEngine(RunsafePlugin plugin, RunsafeConfigurationHandler configuration, IOutput output)
	{
		this(plugin, configuration, output, null);
	}

	public ConfigurationEngine(
		RunsafePlugin plugin,
		RunsafeConfigurationHandler configuration,
		IOutput output, IConfigurationChanged[] subscribers)
	{
		this.console = output;
		this.subscribers = subscribers;
		this.configuration = configuration;
		if (plugin instanceof IConfigurationFile)
		{
			IConfigurationFile provider = (IConfigurationFile) plugin;
			this.configFilePath = provider.getConfigurationPath();
			this.configurationFile = provider;
		}
		else
		{
			this.configFilePath = null;
			this.configurationFile = null;
		}
	}

	@Override
	public void start()
	{
	}

	@Override
	public void stop()
	{
	}

	public void load()
	{
		if (this.configFilePath == null)
			return;

		File configFile = new File(this.configFilePath);

		this.configuration.configFile = YamlConfiguration.loadConfiguration(configFile);
		InputStream defaults = this.configurationFile.getDefaultConfiguration();
		if (defaults != null)
		{
			this.configuration.configFile.setDefaults(YamlConfiguration.loadConfiguration(defaults));
			this.configuration.configFile.options().copyDefaults(true);
		}
		this.save();
		notifySubscribers();
	}

	public boolean restoreToDefaults()
	{
		if (this.configuration.configFile.getDefaults() != null)
		{
			this.configuration.configFile.options().copyDefaults(true);
			this.save();
			this.console.write("Configuration restored to defaults.");
			return true;
		}
		return false;
	}

	public void save()
	{
		if (this.configuration.configFile != null)
		{
			try
			{
				this.configuration.configFile.save(new File(this.configFilePath));
			}
			catch (IOException ex)
			{
				this.console.writeColoured("Unable to save to configuration file: %s", this.configFilePath);
			}
		}
	}

	private void notifySubscribers()
	{
		if (subscribers != null)
		{
			for (IConfigurationChanged sub : subscribers)
			{
				try
				{
					console.fine(
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
	private final RunsafeConfigurationHandler configuration;
	private final String configFilePath;
	private final IConfigurationFile configurationFile;
}
