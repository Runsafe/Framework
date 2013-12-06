package no.runsafe.framework.api;

import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public interface IConfiguration
{
	/**
	 * @param value The configuration key
	 * @return The value as a String
	 */
	String getConfigValueAsString(String key);

	/**
	 * @param value The configuration key
	 * @return The value as a boolean
	 */
	boolean getConfigValueAsBoolean(String key);

	/**
	 * @param value The configuration key
	 * @return The value as an Integer
	 */
	int getConfigValueAsInt(String key);

	/**
	 * @param value The configuration key
	 * @return The value as a double precision float
	 */
	double getConfigValueAsDouble(String key);

	/**
	 * @param value The configuration key
	 * @return The value as a float
	 */
	float getConfigValueAsFloat(String key);

	/**
	 * @param value The configuration key
	 * @return The value as a list of strings
	 */
	List<String> getConfigValueAsList(String key);

	/**
	 * @param value The configuration key
	 * @return The value as a list of integers
	 */
	List<Integer> getConfigValueAsIntegerList(String key);

	/**
	 * @param key   The configuration key
	 * @param value The value to set the configuration option to
	 */
	void setConfigValue(String key, Object value);

	/**
	 * @param path The configuration key
	 * @return The section as a String map
	 */
	Map<String, String> getConfigValuesAsMap(String key);

	/**
	 * @param path The configuration key
	 * @return The section as a Integer map
	 */
	Map<String, Integer> getConfigValuesAsIntegerMap(String key);

	/**
	 * @param path The configuration key
	 * @return The section as a map of String maps
	 */
	Map<String, Map<String, String>> getConfigSectionsAsMap(String key);

	/**
	 * @param path The configuration key
	 * @return The section as a map of String lists
	 */
	Map<String, List<String>> getConfigSectionsAsList(String key);

	/**
	 * @param path The configuration key
	 * @return The section as a map of Integer lists
	 */
	Map<String, List<Integer>> getConfigSectionsAsIntegerList(String key);

	/**
	 * @param path The configuration key
	 * @return The RunsafeWorld with the matching name for the value.
	 */
	RunsafeWorld getConfigValueAsWorld(String key);

	/**
	 * @param path The configuration path.
	 * @return The RunsafeLocation from the matching value.
	 */
	@Nullable
	RunsafeLocation getConfigValueAsLocation(String key);

	/**
	 * Writes configuration to disk
	 */
	void save();
}