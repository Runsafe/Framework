package no.runsafe.framework.internal.configuration;

import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.IOutput;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class handles configuration file access
 */
public final class Configuration implements IConfiguration
{
	public Configuration(IOutput console)
	{
		this.console = console;
	}

	@Nullable
	@Override
	public String getConfigValueAsString(String value)
	{
		if (configFile == null)
			return null;
		return configFile.getString(value);
	}

	@Override
	public boolean getConfigValueAsBoolean(String key)
	{
		String value = getConfigValueAsString(key);
		return value != null && Boolean.parseBoolean(value);
	}

	@Override
	public int getConfigValueAsInt(String key)
	{
		String value = getConfigValueAsString(key);
		if (value == null)
			return 0;
		return Integer.parseInt(value);
	}

	@Override
	public double getConfigValueAsDouble(String key)
	{
		String value = getConfigValueAsString(key);
		if (value == null)
			return 0;
		return Double.parseDouble(value);
	}

	@Override
	public float getConfigValueAsFloat(String key)
	{
		String value = getConfigValueAsString(key);
		if (value == null)
			return 0;
		return Float.parseFloat(value);
	}

	@Nullable
	@Override
	public List<String> getConfigValueAsList(String value)
	{
		if (configFile == null)
			return null;
		return configFile.getStringList(value);
	}

	@Nullable
	@Override
	public List<Integer> getConfigValueAsIntegerList(String value)
	{
		if (configFile == null)
			return null;
		return configFile.getIntegerList(value);
	}

	@Nullable
	@Override
	public Map<String, String> getConfigValuesAsMap(String path)
	{
		if (configFile == null)
			return null;
		ConfigurationSection section = configFile.getConfigurationSection(path);
		Map<String, String> values = new HashMap<String, String>();
		if (section != null)
			for (String key : section.getKeys(true))
				values.put(key, section.getString(key));
		return values;
	}

	@Nullable
	@Override
	public Map<String, Integer> getConfigValuesAsIntegerMap(String path)
	{
		if (configFile == null)
			return null;
		ConfigurationSection section = configFile.getConfigurationSection(path);
		Map<String, Integer> values = new HashMap<String, Integer>();
		if (section != null)
			for (String key : section.getKeys(true))
				values.put(key, section.getInt(key));
		return values;
	}

	@Nullable
	@Override
	public Map<String, Map<String, String>> getConfigSectionsAsMap(String path)
	{
		if (configFile == null)
			return null;
		ConfigurationSection section = configFile.getConfigurationSection(path);
		Map<String, Map<String, String>> results = new HashMap<String, Map<String, String>>();
		if (section != null)
			for (String key : section.getKeys(false))
				results.put(key, getConfigValuesAsMap(path + "." + key));
		return results;
	}

	@Nullable
	@Override
	public Map<String, List<String>> getConfigSectionsAsList(String path)
	{
		if (configFile == null)
			return null;
		ConfigurationSection section = configFile.getConfigurationSection(path);
		Map<String, List<String>> results = new HashMap<String, List<String>>();
		if (section != null)
			for (String key : section.getKeys(true))
				results.put(key, getConfigValueAsList(path + "." + key));
		return results;
	}

	@Nullable
	@Override
	public Map<String, List<Integer>> getConfigSectionsAsIntegerList(String path)
	{
		if (configFile == null)
			return null;
		ConfigurationSection section = configFile.getConfigurationSection(path);
		Map<String, List<Integer>> results = new HashMap<String, List<Integer>>();
		if (section != null)
			for (String key : section.getKeys(true))
				results.put(key, getConfigValueAsIntegerList(path + "." + key));
		return results;
	}

	@Override
	public void setConfigValue(String key, Object value)
	{
		configFile.set(key, value);
	}

	@Override
	public void save()
	{
		if (configFile != null)
		{
			try
			{
				configFile.save(new File(configFilePath));
			}
			catch (IOException ex)
			{
				console.writeColoured("Unable to save to configuration file: %s", configFilePath);
				console.logException(ex);
			}
		}
	}

	FileConfiguration configFile;
	String configFilePath;
	private final IOutput console;
}
