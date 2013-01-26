package no.runsafe.framework.configuration;

import no.runsafe.framework.output.IOutput;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class handles configuration file access
 */
public class RunsafeConfigurationHandler implements IConfiguration
{
	public RunsafeConfigurationHandler(IOutput console)
	{
		this.console = console;
	}

	@Override
	public String getConfigValueAsString(String value)
	{
		if (this.configFile == null)
			return null;
		return this.configFile.getString(value);
	}

	@Override
	public boolean getConfigValueAsBoolean(String key)
	{
		String value = this.getConfigValueAsString(key);
		return value != null && Boolean.parseBoolean(value);
	}

	@Override
	public int getConfigValueAsInt(String key)
	{
		String value = this.getConfigValueAsString(key);
		if (value == null)
			return 0;
		return Integer.parseInt(value);
	}

	@Override
	public double getConfigValueAsDouble(String key)
	{
		String value = this.getConfigValueAsString(key);
		if (value == null)
			return 0;
		return Double.parseDouble(value);
	}

	@Override
	public float getConfigValueAsFloat(String key)
	{
		String value = this.getConfigValueAsString(key);
		if (value == null)
			return 0;
		return Float.parseFloat(value);
	}

	@Override
	public List<String> getConfigValueAsList(String value)
	{
		if (this.configFile == null)
			return null;
		return this.configFile.getStringList(value);
	}

	@Override
	public List<Integer> getConfigValueAsIntegerList(String value)
	{
		if (this.configFile == null)
			return null;
		return this.configFile.getIntegerList(value);
	}

	@Override
	public Map<String, String> getConfigValuesAsMap(String path)
	{
		if (this.configFile == null)
			return null;
		ConfigurationSection section = this.configFile.getConfigurationSection(path);
		HashMap<String, String> values = new HashMap<String, String>();
		for (String key : section.getKeys(true))
			values.put(key, section.getString(key));
		return values;
	}

	@Override
	public Map<String, Integer> getConfigValuesAsIntegerMap(String path)
	{
		if (this.configFile == null)
			return null;
		ConfigurationSection section = this.configFile.getConfigurationSection(path);
		HashMap<String, Integer> values = new HashMap<String, Integer>();
		for (String key : section.getKeys(true))
			values.put(key, section.getInt(key));
		return values;
	}

	@Override
	public Map<String, Map<String, String>> getConfigSectionsAsMap(String path)
	{
		if (this.configFile == null)
			return null;
		ConfigurationSection section = this.configFile.getConfigurationSection(path);
		HashMap<String, Map<String, String>> results = new HashMap<String, Map<String, String>>();
		for (String key : section.getKeys(false))
			results.put(key, getConfigValuesAsMap(path + "." + key));
		return results;
	}

	@Override
	public Map<String, List<String>> getConfigSectionsAsList(String path)
	{
		if (this.configFile == null)
			return null;
		ConfigurationSection section = this.configFile.getConfigurationSection(path);
		HashMap<String, List<String>> results = new HashMap<String, List<String>>();
		for (String key : section.getKeys(true))
			results.put(key, getConfigValueAsList(path + "." + key));
		return results;
	}

	@Override
	public Map<String, List<Integer>> getConfigSectionsAsIntegerList(String path)
	{
		if (this.configFile == null)
			return null;
		ConfigurationSection section = this.configFile.getConfigurationSection(path);
		HashMap<String, List<Integer>> results = new HashMap<String, List<Integer>>();
		for (String key : section.getKeys(true))
			results.put(key, getConfigValueAsIntegerList(path + "." + key));
		return results;
	}

	@Override
	@Deprecated
	public ConfigurationSection getSection(String path)
	{
		return this.configFile.getConfigurationSection(path);
	}

	@Override
	public void setConfigValue(String key, Object value)
	{
		this.configFile.set(key, value);
	}

	@Override
	public void save()
	{
		if (this.configFile != null)
		{
			try
			{
				this.configFile.save(new File(this.configFilePath));
			}
			catch (IOException ex)
			{
				this.console.writeColoured("Unable to save to configuration file: %s", this.configFilePath);
				this.console.logException(ex);
			}
		}
	}

	FileConfiguration configFile;
	String configFilePath;
	private final IOutput console;
}
