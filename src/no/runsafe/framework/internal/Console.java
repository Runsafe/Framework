package no.runsafe.framework.internal;

import no.runsafe.framework.api.IConsole;
import no.runsafe.framework.text.ChatColour;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Console implements IConsole
{
	protected Console(InjectionPlugin plugin)
	{
		if (plugin != null && pluginFormat.containsKey(plugin.getName()))
			format = (String) pluginFormat.get(plugin.getName());
		else if (plugin != null && pluginFormat.containsKey("*"))
			format = String.format((String) pluginFormat.get("*"), plugin.getName());
	}

	@Override
	public void logException(Exception exception)
	{
		writeColoured(
			"Exception caught: &c%s&r\n%s",
			Level.SEVERE,
			ExceptionUtils.getMessage(exception),
			ExceptionUtils.getStackTrace(exception)
		);
	}

	@Override
	public void logWarning(String message, Object... params)
	{
		outputToConsole(ChatColour.ToConsole("&e" + String.format(message.replace("&r", "&e"), params) + "&r"), Level.WARNING);
	}

	@Override
	public void logError(String message, Object... params)
	{
		outputToConsole(ChatColour.ToConsole("&4" + String.format(message.replace("&r", "&4"), params) + "&r"), Level.SEVERE);
	}

	/**
	 * This will log a fatal error and make the server die in a great big fireball.
	 *
	 * @param message The message to print before exiting the process.
	 * @param params  Values to be passed into the message using String.format
	 */
	@Override
	public void logFatal(String message, Object... params)
	{
		String formatted = String.format(message, params);
		String border = StringUtils.repeat("=", formatted.length());
		writeColoured("\n\n&4&l%1$s\n%2$s\n%1$s&r", Level.SEVERE, border, formatted);
		System.exit(1);
	}

	@Override
	public void logInformation(String message, Object... params)
	{
		outputToConsole(ChatColour.ToConsole("&2" + String.format(message.replace("&r", "&2"), params) + "&r"), Level.INFO);
	}

	// Sends the supplied String to the console/log the output handler has
	@Override
	public void outputToConsole(String message)
	{
		outputToConsole(message, Level.INFO);
	}

	// Sends the supplied String with the supplied logging level to the console/log the output handler has
	@Override
	public void outputToConsole(String message, Level level)
	{
		InternalLogger.log(level, message, this);
	}

	@Override
	public void writeColoured(String message)
	{
		writeColoured(message.replace("%", "%%"), Level.INFO);
	}

	@Override
	public void writeColoured(String message, Object... params)
	{
		writeColoured(message, Level.INFO, params);
	}

	@Override
	public void writeColoured(String message, Level level, Object... params)
	{
		outputToConsole(ChatColour.ToConsole(String.format(message, params)), level);
	}

	@Override
	public String getFormat()
	{
		return format;
	}

	private String format;

	public static final Level DefaultDebugLevel;

	protected static final Map<String, Object> pluginFormat;
	protected static final Logger InternalLogger;

	static
	{
		File configFile = new File("runsafe", "output.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
		if (!config.contains("debug"))
			config.set("debug", "OFF");
		if (!config.contains("split"))
			config.set("split", false);
		if (!config.contains("format"))
			config.set("format", "%1$s %2$s [%3$s] %4$s");
		if (!config.contains("pluginformat.*"))
			config.set("pluginformat.*", "%%1$s %%2$s [%%3$s] [%s] %%4$s");
		ConfigurationSection plugins = config.getConfigurationSection("pluginformat");
		pluginFormat = plugins.getValues(false);
		try
		{
			config.save(configFile);
		}
		catch (IOException e)
		{
		}
		DefaultDebugLevel = Level.parse(config.getString("debug").toUpperCase());
		InternalLogger = Logger.getLogger("Runsafe");
		InternalLogger.setUseParentHandlers(!config.getBoolean("split"));
		try
		{
			FileHandler logFile = new FileHandler("runsafe.log", true);
			logFile.setEncoding("UTF-8");
			logFile.setFormatter(new RunsafeLogFormatter(config.getString("format")));
			InternalLogger.addHandler(logFile);
		}
		catch (IOException e)
		{
		}
	}
}
