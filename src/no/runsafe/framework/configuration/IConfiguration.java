package no.runsafe.framework.configuration;

import java.util.List;

import org.bukkit.configuration.ConfigurationSection;

public interface IConfiguration {

	// Loads the configuration from disk. Prepares defaults if available.
	public abstract void load();

	// Replaces the current configuration values with the supplied defaults
	public abstract boolean restoreToDefaults();

	// Saves the current configuration file to disk
	public abstract void save();

	// Returns a configuration value as a string
	public abstract String getConfigValueAsString(String value);

    // Returns a configuration value as a boolean
    public abstract boolean getConfigValueAsBoolean(String value);

	// Returns a configuration value as an integer
	public abstract int getConfigValueAsInt(String value);

	// Returns a configuration value as a double
	public abstract double getConfigValueAsDouble(String value);

	// Returns a configuration value as a float
	public abstract float getConfigValueAsFloat(String value);

	public abstract List<String> getConfigValueAsList(String value);

	// Sets a configuration value with the specified key -> value
	public abstract void setConfigValue(String key, Object value);

	public abstract ConfigurationSection getSection(String path);
}