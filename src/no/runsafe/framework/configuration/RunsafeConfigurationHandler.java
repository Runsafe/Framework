package no.runsafe.framework.configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import no.runsafe.framework.FrameworkMessages;
import no.runsafe.framework.interfaces.IConfiguration;
import no.runsafe.framework.interfaces.IConfigurationDefaults;
import no.runsafe.framework.interfaces.IConfigurationFile;
import no.runsafe.framework.interfaces.IOutput;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public class RunsafeConfigurationHandler implements IConfiguration {

	private String configFilePath;
	private IConfigurationDefaults defaultConfigFile;
	private IOutput pluginOutput;
	private FileConfiguration configFile;
	
	public RunsafeConfigurationHandler(IOutput pluginOutput, IConfigurationFile configFileProvider, IConfigurationDefaults configDefaultProvider)
	{
		this.pluginOutput = pluginOutput;
		this.configFilePath = configFileProvider.getConfigurationPath();
		this.defaultConfigFile = configDefaultProvider;
		this.load();
	}
	
	@Override
	public void load()
	{
		if (this.configFilePath == null)
			return;
		
		File configFile = new File(this.configFilePath);
		if(!configFile.exists() && this.defaultConfigFile != null)
		{
			this.output(FrameworkMessages.configurationInfo_defaults);
		}

		this.configFile = YamlConfiguration.loadConfiguration(configFile);
		
		if (this.defaultConfigFile != null)
		{
			this.configFile.setDefaults(YamlConfiguration.loadConfiguration(this.defaultConfigFile.getDefaultConfiguration()));
		}
		this.configFile.options().copyDefaults(true);
		this.save();
	}
	
	// Replaces the current configuration values with the supplied defaults
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IConfiguration#restoreToDefaults()
	 */
	@Override
	public boolean restoreToDefaults()
	{
		if (this.configFile.getDefaults() != null)
		{
			this.configFile.options().copyDefaults(true);
			this.save();
			this.output(FrameworkMessages.configurationInfo_restored);
			return true;
		}
		return false;
	}
	
	// Saves the current configuration file to disk
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IConfiguration#save()
	 */
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
				this.output(String.format(FrameworkMessages.configurationError_save, this.configFilePath), Level.SEVERE);
			}
		}
	}
	
	// Returns a configuration value as a string
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IConfiguration#getConfigValueAsString(java.lang.String)
	 */
	@Override
	public String getConfigValueAsString(String value)
	{
		return this.configFile.getString(value);
	}
	
	// Returns a configuration value as an integer
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IConfiguration#getConfigValueAsInt(java.lang.String)
	 */
	@Override
	public int getConfigValueAsInt(String value)
	{
		return Integer.parseInt(this.getConfigValueAsString(value));
	}
	
	// Returns a configuration value as a double
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IConfiguration#getConfigValueAsDouble(java.lang.String)
	 */
	@Override
	public double getConfigValueAsDouble(String value)
	{
		return Double.parseDouble(this.getConfigValueAsString(value));
	}
	
	// Returns a configuration value as a float
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IConfiguration#getConfigValueAsFloat(java.lang.String)
	 */
	@Override
	public float getConfigValueAsFloat(String value)
	{
		return Float.parseFloat(this.getConfigValueAsString(value));
	}
	
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IConfiguration#getConfigValueAsList(java.lang.String)
	 */
	@Override
	public List<String> getConfigValueAsList(String value)
	{
		return this.configFile.getStringList(value);
	}
	
	@Override
	public ConfigurationSection getSection(String path) 
	{
		return this.configFile.getConfigurationSection(path);
	}
	
	// Sets a configuration value with the specified key -> value
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IConfiguration#setConfigValue(java.lang.String, java.lang.Object)
	 */
	@Override
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