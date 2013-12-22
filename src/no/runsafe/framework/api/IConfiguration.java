package no.runsafe.framework.api;

import no.runsafe.framework.minecraft.Item;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IConfiguration
{
	/**
	 * @param key The configuration key
	 * @return The value as a String
	 */
	String getConfigValueAsString(String key);

	/**
	 * @param key The configuration key
	 * @return The value as a boolean
	 */
	boolean getConfigValueAsBoolean(String key);

	/**
	 * @param key The configuration key
	 * @return The value as an Integer
	 */
	int getConfigValueAsInt(String key);

	/**
	 * @param key The configuration key
	 * @return The value as a double precision float
	 */
	double getConfigValueAsDouble(String key);

	/**
	 * @param key The configuration key
	 * @return The value as a float
	 */
	float getConfigValueAsFloat(String key);

	/**
	 * @param key The configuration key
	 * @return The value as a list of strings
	 */
	List<String> getConfigValueAsList(String key);

	/**
	 * @param key The configuration key
	 * @return The value as a list of integers
	 */
	List<Integer> getConfigValueAsIntegerList(String key);

	@Nullable
	Item getConfigValueAsItem(String key);

	/**
	 * @param key   The configuration key
	 * @param value The value to set the configuration option to
	 */
	void setConfigValue(String key, Object value);

	/**
	 * @param key The configuration key
	 * @return The section as a String map
	 */
	Map<String, String> getConfigValuesAsMap(String key);

	/**
	 * @param key The configuration key
	 * @return The section as a Integer map
	 */
	Map<String, Integer> getConfigValuesAsIntegerMap(String key);

	/**
	 * @param key The configuration key
	 * @return The section as a map of String maps
	 */
	Map<String, Map<String, String>> getConfigSectionsAsMap(String key);

	/**
	 * @param key The configuration key
	 * @return The section as a map of String lists
	 */
	Map<String, List<String>> getConfigSectionsAsList(String key);

	/**
	 * @param key The configuration key
	 * @return The section as a map of Integer lists
	 */
	Map<String, List<Integer>> getConfigSectionsAsIntegerList(String key);

	/**
	 * @param key The configuration key
	 * @return The IWorld with the matching name for the value.
	 */
	IWorld getConfigValueAsWorld(String key);

	/**
	 * @param key The configuration path.
	 * @return The ILocation from the matching value.
	 */
	@Nullable
	ILocation getConfigValueAsLocation(String key);

	Set<String> getConfigurationKeys();

	/**
	 * Writes configuration to disk
	 */
	void save();

	boolean reset();
}