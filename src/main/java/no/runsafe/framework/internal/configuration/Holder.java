package no.runsafe.framework.internal.configuration;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.item.Configurable;
import no.runsafe.framework.api.item.IMaterial;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.internal.brane.Multiverse;
import no.runsafe.framework.internal.log.Console;
import no.runsafe.framework.minecraft.Item;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

public class Holder
{
	public Holder(IDebug debugger, IConsole console)
	{
		this.debugger = debugger;
		this.console = console;
	}

	@Nullable
	public String getConfigValueAsString(String key)
	{
		if (configFile == null)
			return null;
		return configFile.getString(key);
	}

	public boolean getConfigValueAsBoolean(String key)
	{
		String value = getConfigValueAsString(key);
		return Boolean.parseBoolean(value);
	}

	public int getConfigValueAsInt(String key)
	{
		String value = getConfigValueAsString(key);
		if (value == null)
			return 0;
		return Integer.parseInt(value);
	}

	public double getConfigValueAsDouble(String key)
	{
		String value = getConfigValueAsString(key);
		if (value == null)
			return 0.0D;
		return Double.parseDouble(value);
	}

	public float getConfigValueAsFloat(String key)
	{
		String value = getConfigValueAsString(key);
		if (value == null)
			return 0.0f;
		return Float.parseFloat(value);
	}

	@Nullable
	public List<String> getConfigValueAsList(String key)
	{
		if (configFile == null)
			return null;
		return configFile.getStringList(key);
	}

	@Nullable
	public List<Integer> getConfigValueAsIntegerList(String key)
	{
		if (configFile == null)
			return null;
		return configFile.getIntegerList(key);
	}

	@Nullable
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

	public IWorld getConfigValueAsWorld(String key)
	{
		return Multiverse.getInstance().getWorld(getConfigValueAsString(key));
	}

	@Nullable
	public ILocation getConfigValueAsLocation(String key)
	{
		if (configFile == null)
			return null;

		ConfigurationSection section = configFile.getConfigurationSection(key);
		if (section == null)
			return null;

		if (section.contains("world") && section.contains("x") && section.contains("y") && section.contains("z"))
		{
			IWorld world = getConfigValueAsWorld(key + ".world");
			if (world == null)
				return null;

			ILocation location = world.getLocation(
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

	public IMaterial getConfigValueAsMaterial(String key)
	{
		return Configurable.getMaterial(getConfigValueAsString(key));
	}

	@Nullable
	public Item getConfigValueAsItem(String key)
	{
		if (configFile == null)
			return null;

		return Item.get(configFile.getString(key));
	}

	public void setConfigValue(String key, Object value)
	{
		configFile.set(key, value);
	}

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
				if (console == null)
				{
					logFatal(ex);
					return;
				}
				console.logError("Unable to save to configuration file: %s", Level.FINE, configFilePath);
				console.logException(ex);
			}
		}
	}

	public void load(File file)
	{
		configFilePath = file.getPath();
		configFile = YamlConfiguration.loadConfiguration(file);
	}

	public Set<String> getConfigurationKeys()
	{
		return configFile.getKeys(true);
	}

	public boolean reset()
	{
		if (configFile.getDefaults() != null)
		{
			FileConfiguration oldConfig = configFile;
			configFile = new YamlConfiguration();
			configFile.setDefaults(oldConfig.getDefaults());
			configFile.options().copyDefaults(true);
			save();
			if (console != null)
				console.logInformation("Configuration restored to defaults.");
			return true;
		}
		return false;
	}

	private static void logFatal(IOException ex)
	{
		IConsole globalConsole = Console.Global();
		globalConsole.logException(ex);
		globalConsole.logFatal("Fatal exception occurred in framework configuration. Aborting!");
	}

	protected final IConsole console;
	protected final IDebug debugger;
	protected FileConfiguration configFile;
	protected String configFilePath;
}
