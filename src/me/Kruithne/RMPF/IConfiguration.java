package me.Kruithne.RMPF;

import java.io.InputStream;
import java.util.List;

public interface IConfiguration {

	public abstract void setConfigFilePath(String path);

	public abstract void setDefaultConfigFile(InputStream defaultConfigFile);

	/*
	// Default constructor using only the config file path
	public RMPFConfiguration(String configFilePath)
	{
		this.configFilePath = configFilePath;
		this.load();
	}
	
	// Secondary constructor with supplied outputter for errors/info debug
	public RMPFConfiguration(String configFilePath, RMPFOutput pluginOutput)
	{
		this.configFilePath = configFilePath;
		this.pluginOutput = pluginOutput;
		this.load();
	}
	
	// Constructor with an extra parameter to supply a defualt configuraion file
	public RMPFConfiguration(String configFilePath, RMPFOutput pluginOutput, InputStream defaultConfigFile)
	{
		this.configFilePath = configFilePath;
		this.pluginOutput = pluginOutput;
		this.defaultConfigFile = defaultConfigFile;
		this.load();
	}
	
	// Secondary constructor with supplied outputter for errors/info debug
	public RMPFConfiguration(String configFilePath, InputStream defaultConfigFile)
	{
		this.configFilePath = configFilePath;
		this.defaultConfigFile = defaultConfigFile;
		this.load();
	}
	 */
	// Loads the configuration from disk. Prepares defaults if available.
	public abstract void load();

	// Replaces the current configuration values with the supplied defaults
	public abstract boolean restoreToDefaults();

	// Saves the current configuration file to disk
	public abstract void save();

	// Returns a configuration value as a string
	public abstract String getConfigValueAsString(String value);

	// Returns a configuration value as an integer
	public abstract int getConfigValueAsInt(String value);

	// Returns a configuration value as a double
	public abstract double getConfigValueAsDouble(String value);

	// Returns a configuration value as a float
	public abstract float getConfigValueAsFloat(String value);

	public abstract List<String> getConfigValueAsList(String value);

	// Sets a configuration value with the specified key -> value
	public abstract void setConfigValue(String key, Object value);

}