package me.Kruithne.RMPF;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public class RMPFConfiguration {

	private String configFilePath;
	private InputStream defaultConfigFile;
	
	private RMPFOutput pluginOutput;
	private FileConfiguration configFile;
	
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
	
	// Loads the configuration from disk. Prepares defaults if available.
	public void load()
	{
		if (this.configFile == null)
		{
			this.configFile = YamlConfiguration.loadConfiguration(new File(this.configFilePath));
		}
		
		if (this.defaultConfigFile != null)
		{
			this.configFile.setDefaults(YamlConfiguration.loadConfiguration(defaultConfigFile));
			this.output(RMPFConstants.configurationInfo_defaults);
		}
		this.configFile.options().copyDefaults(true);
		this.save();
	}
	
	// Replaces the current configuration values with the supplied defaults
	public boolean restoreToDefaults()
	{
		if (this.configFile.getDefaults() != null)
		{
			this.configFile.options().copyDefaults(true);
			this.save();
			this.output(RMPFConstants.configurationInfo_restored);
			return true;
		}
		return false;
	}
	
	// Saves the current configuration file to disk
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
				this.output(String.format(RMPFConstants.configurationError_save, this.configFilePath), Level.SEVERE);
			}
		}
	}
	
	// Returns a configuration value as a string
	public String getConfigValueAsString(String value)
	{
		return this.configFile.getString(value);
	}
	
	// Returns a configuration value as an integer
	public int getConfigValueAsInt(String value)
	{
		return Integer.parseInt(this.getConfigValueAsString(value));
	}
	
	// Returns a configuration value as a double
	public double getConfigValueAsDouble(String value)
	{
		return Double.parseDouble(this.getConfigValueAsString(value));
	}
	
	// Returns a configuration value as a float
	public float getConfigValueAsFloat(String value)
	{
		return Float.parseFloat(this.getConfigValueAsString(value));
	}
	
	public List<String> getConfigValueAsList(String value)
	{
		return this.configFile.getStringList(value);
	}
	
	// Sets a configuration value with the specified key -> value
	public void setConfigValue(String key, Object value)
	{
		this.configFile.set(key, value);
	}
	
	private void output(String message)
	{
		if (this.pluginOutput != null)
		{
			this.pluginOutput.outputToConsole(message);
		}
	}
	
	private void output(String message, Level level)
	{
		if (this.pluginOutput != null)
		{
			this.pluginOutput.outputToConsole(message, level);
		}
	}
	
}
