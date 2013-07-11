package no.runsafe.framework.api;

import java.util.List;
import java.util.Map;

public interface IConfiguration
{
	/**
	 * @param value The configuration key
	 * @return The value as a String
	 */
	String getConfigValueAsString(String value);

	/**
	 * @param value The configuration key
	 * @return The value as a boolean
	 */
	boolean getConfigValueAsBoolean(String value);

	/**
	 * @param value The configuration key
	 * @return The value as an Integer
	 */
	int getConfigValueAsInt(String value);

	/**
	 * @param value The configuration key
	 * @return The value as a double precision float
	 */
	double getConfigValueAsDouble(String value);

	/**
	 * @param value The configuration key
	 * @return The value as a float
	 */
	float getConfigValueAsFloat(String value);

	/**
	 * @param value The configuration key
	 * @return The value as a list of strings
	 */
	List<String> getConfigValueAsList(String value);

	/**
	 * @param value The configuration key
	 * @return The value as a list of integers
	 */
	List<Integer> getConfigValueAsIntegerList(String value);

	/**
	 * @param key   The configuration key
	 * @param value The value to set the configuration option to
	 */
	void setConfigValue(String key, Object value);

	/**
	 * @param path The configuration key
	 * @return The section as a String map
	 */
	Map<String, String> getConfigValuesAsMap(String path);

	/**
	 * @param path The configuration key
	 * @return The section as a Integer map
	 */
	Map<String, Integer> getConfigValuesAsIntegerMap(String path);

	/**
	 * @param path The configuration key
	 * @return The section as a map of String maps
	 */
	Map<String, Map<String, String>> getConfigSectionsAsMap(String path);

	/**
	 * @param path The configuration key
	 * @return The section as a map of String lists
	 */
	Map<String, List<String>> getConfigSectionsAsList(String path);

	/**
	 * @param path The configuration key
	 * @return The section as a map of Integer lists
	 */
	Map<String, List<Integer>> getConfigSectionsAsIntegerList(String path);

	/**
	 * Writes configuration to disk
	 */
	void save();
}