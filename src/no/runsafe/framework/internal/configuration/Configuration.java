package no.runsafe.framework.internal.configuration;

import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.IDebug;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.RunsafeWorld;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/**
 * This class handles configuration file access
 */
public final class Configuration implements IConfiguration
{
	public Configuration(IDebug console)
	{
		this.console = console;
	}

	@Nullable
	@Override
	public String getConfigValueAsString(String key)
	{
		if (configFile == null)
			return null;
		return configFile.getString(key);
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
			return 0.0D;
		return Double.parseDouble(value);
	}

	@Override
	public float getConfigValueAsFloat(String key)
	{
		String value = getConfigValueAsString(key);
		if (value == null)
			return 0.0f;
		return Float.parseFloat(value);
	}

	@Nullable
	@Override
	public List<String> getConfigValueAsList(String key)
	{
		if (configFile == null)
			return null;
		return configFile.getStringList(key);
	}

	@Nullable
	@Override
	public List<Integer> getConfigValueAsIntegerList(String key)
	{
		if (configFile == null)
			return null;
		return configFile.getIntegerList(key);
	}

	@Nullable
	@Override
	public Map<String, String> getConfigValuesAsMap(String key)
	{
		if (configFile == null)
			return null;
		ConfigurationSection section = configFile.getConfigurationSection(key);
		Map<String, String> values = new HashMap<String, String>(1);
		if (section != null)
			for (String subKey : section.getKeys(true))
				values.put(subKey, section.getString(subKey));
		return values;
	}

	@Nullable
	@Override
	public Map<String, Integer> getConfigValuesAsIntegerMap(String key)
	{
		if (configFile == null)
			return null;
		ConfigurationSection section = configFile.getConfigurationSection(key);
		Map<String, Integer> values = new HashMap<String, Integer>(1);
		if (section != null)
			for (String subKey : section.getKeys(true))
				values.put(subKey, section.getInt(subKey));
		return values;
	}

	@Nullable
	@Override
	public Map<String, Map<String, String>> getConfigSectionsAsMap(String key)
	{
		if (configFile == null)
			return null;
		ConfigurationSection section = configFile.getConfigurationSection(key);
		Map<String, Map<String, String>> results = new HashMap<String, Map<String, String>>(1);
		if (section != null)
			for (String subKey : section.getKeys(false))
				results.put(subKey, getConfigValuesAsMap(key + '.' + subKey));
		return results;
	}

	@Nullable
	@Override
	public Map<String, List<String>> getConfigSectionsAsList(String key)
	{
		if (configFile == null)
			return null;
		ConfigurationSection section = configFile.getConfigurationSection(key);
		Map<String, List<String>> results = new HashMap<String, List<String>>(1);
		if (section != null)
			for (String subKey : section.getKeys(true))
				results.put(subKey, getConfigValueAsList(key + '.' + subKey));
		return results;
	}

	@Nullable
	@Override
	public Map<String, List<Integer>> getConfigSectionsAsIntegerList(String key)
	{
		if (configFile == null)
			return null;
		ConfigurationSection section = configFile.getConfigurationSection(key);
		Map<String, List<Integer>> results = new HashMap<String, List<Integer>>(1);
		if (section != null)
			for (String subKey : section.getKeys(true))
				results.put(subKey, getConfigValueAsIntegerList(key + '.' + subKey));
		return results;
	}

	@Override
	public RunsafeWorld getConfigValueAsWorld(String key)
	{
		return RunsafeServer.Instance.getWorld(getConfigValueAsString(key));
	}

	@Nullable
	@SuppressWarnings("LocalVariableOfConcreteClass")
	@Override
	public RunsafeLocation getConfigValueAsLocation(String key)
	{
		if (configFile == null)
			return null;

		ConfigurationSection section = configFile.getConfigurationSection(key);
		if (section == null)
			return null;

		if (section.contains("world") && section.contains("x") && section.contains("y") && section.contains("z"))
		{
			RunsafeWorld world = getConfigValueAsWorld(key + ".world");
			if (world == null)
				return null;

			RunsafeLocation location = new RunsafeLocation(
				world,
				section.getDouble("x"),
				section.getDouble("y"),
				section.getDouble("z")
			);

			if (section.contains("yaw"))
				location.setYaw(Float.parseFloat(section.getString("yaw")));

			if (section.contains("pitch"))
				location.setPitch(Float.parseFloat(section.getString("pitch")));

			return location;
		}
		return null;
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
				console.writeColoured("Unable to save to configuration file: %s", Level.FINE, configFilePath);
				console.logException(ex);
			}
		}
	}

	protected FileConfiguration configFile;
	protected String configFilePath;
	private final IDebug console;
}
