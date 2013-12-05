package no.runsafe.framework.internal;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.IPluginUpdate;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.picocontainer.Startable;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public final class VersionEngine implements Startable
{
	public VersionEngine(RunsafePlugin plugin, IOutput output)
	{
		this(plugin, output, null);
	}

	public VersionEngine(RunsafePlugin plugin, IOutput output, IPluginUpdate updater)
	{
		this.plugin = plugin;
		this.updater = updater;
		this.output = output;
	}

	@Override
	public void start()
	{
		String lastVersion = getLastVersion();
		if (!plugin.getDescription().getVersion().equals(lastVersion))
		{
			if (updater == null || updater.updateFrom(lastVersion))
				saveCurrentVersion();
		}
		output.debugFiner("Plugin version logged.");
	}

	@Override
	public void stop()
	{
	}

	@SuppressWarnings("OverlyBroadCatchBlock")
	@Nullable
	String getLastVersion()
	{
		YamlConfiguration config = new YamlConfiguration();
		File configFile = new File("runsafe", "plugins.yml");
		try
		{
			config.load(configFile);
		}
		catch (IOException ignored)
		{
			return null;
		}
		catch (InvalidConfigurationException e)
		{
			output.logException(e);
			output.outputToConsole(String.format("Invalid yml in %s!", configFile), Level.WARNING);
			return null;
		}
		return config.getString(plugin.getName());
	}

	@SuppressWarnings("OverlyBroadCatchBlock")
	void saveCurrentVersion()
	{
		YamlConfiguration config = new YamlConfiguration();
		File configFile = new File("runsafe", "plugins.yml");
		try
		{
			config.load(configFile);
		}
		catch (IOException e)
		{
			output.logException(e);
			output.outputToConsole(String.format("Problem loading %s!", configFile), Level.WARNING);
		}
		catch (InvalidConfigurationException e)
		{
			output.logException(e);
			output.outputToConsole(String.format("Invalid yml in %s!", configFile), Level.WARNING);
		}
		config.set(plugin.getName(), plugin.getDescription().getVersion());
		try
		{
			config.save(configFile);
		}
		catch (IOException e)
		{
			output.logException(e);
			output.outputToConsole(String.format("Unable to save %s!", configFile), Level.SEVERE);
		}
	}

	private final RunsafePlugin plugin;
	private final IPluginUpdate updater;
	private final IOutput output;
}
