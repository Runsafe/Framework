package no.runsafe.framework.configuration;

import org.bukkit.configuration.ConfigurationSection;

import java.util.List;
import java.util.Map;

public interface IConfiguration
{
	// Returns a configuration value as a string
	String getConfigValueAsString(String value);

	// Returns a configuration value as a boolean
	boolean getConfigValueAsBoolean(String value);

	// Returns a configuration value as an integer
	int getConfigValueAsInt(String value);

	// Returns a configuration value as a double
	double getConfigValueAsDouble(String value);

	// Returns a configuration value as a float
	float getConfigValueAsFloat(String value);

	List<String> getConfigValueAsList(String value);

	List<Integer> getConfigValueAsIntegerList(String value);

	// Sets a configuration value with the specified key -> value
	void setConfigValue(String key, Object value);

	@Deprecated
	ConfigurationSection getSection(String path);

	Map<String, String> getConfigValuesAsMap(String path);

	Map<String, Integer> getConfigValuesAsIntegerMap(String path);

	Map<String, Map<String, String>> getConfigSectionsAsMap(String path);

	Map<String, List<String>> getConfigSectionsAsList(String path);

	Map<String, List<Integer>> getConfigSectionsAsIntegerList(String path);

	void save();
}