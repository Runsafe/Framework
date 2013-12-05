package no.runsafe.framework.internal;

import no.runsafe.framework.api.IConsole;
import no.runsafe.framework.text.ChatColour;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
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
		if (plugin != null && logFormats.containsKey(plugin.getName()))
			logFormat = (String) logFormats.get(plugin.getName());
		else if (plugin != null && logFormats.containsKey("*"))
			logFormat = String.format((String) logFormats.get("*"), plugin.getName());

		if (plugin != null && debugFormats.containsKey(plugin.getName()))
			debugFormat = (String) debugFormats.get(plugin.getName());
		else if (plugin != null && debugFormats.containsKey("*"))
			debugFormat = String.format((String) debugFormats.get("*"), plugin.getName());
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
	public void logInformation(String message, Object... params)
	{
		writeColoured("&2%s&r", Level.INFO, String.format(message.replace("&r", "&2"), params));
	}

	@Override
	public void logWarning(String message, Object... params)
	{
		writeColoured("&e%s&r", Level.WARNING, String.format(message.replace("&r", "&e"), params));
	}

	@Override
	public void logError(String message, Object... params)
	{
		writeColoured("&4%s&r", Level.SEVERE, String.format(message.replace("&r", "&4"), params));
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

	@Deprecated
	@Override
	public void writeColoured(String message)
	{
		writeColoured(message.replace("%", "%%"), Level.INFO);
	}

	@Deprecated
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

	// Sends the supplied String to the console/log the output handler has
	@Deprecated
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
	public String getLogFormat()
	{
		return logFormat;
	}

	@Override
	public String getDebugFormat()
	{
		return debugFormat;
	}

	private String logFormat;
	private String debugFormat;

	public static final Level DefaultDebugLevel;

	protected static final Map<String, Object> logFormats;
	protected static final Map<String, Object> debugFormats;
	protected static final Logger InternalLogger;
	protected static final Logger InternalDebugger;

	static
	{
		File configFile = new File("runsafe", "output.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
		if (!config.contains("debug"))
			config.set("debug", "OFF");
		if (!config.contains("split"))
			config.set("split", false);
		if (!config.contains("format.anonymous"))
			config.set("format.anonymous", "%1$s %2$s [%3$s] %4$s");
		if (!config.contains("format.log.*"))
			config.set("format.log.*", "%%1$s %%2$s [%%3$s] [%s] %%4$s");
		if (!config.contains("format.debug.*"))
			config.set("format.debug.*", "%%1$s %%2$s [%%3$s] [%s] %%4$s");
		logFormats = config.getConfigurationSection("format.log").getValues(false);
		debugFormats = config.getConfigurationSection("format.debug").getValues(false);
		try
		{
			config.save(configFile);
		}
		catch (IOException e)
		{
		}
		DefaultDebugLevel = Level.parse(config.getString("debug").toUpperCase());
		InternalLogger = Logger.getLogger("RunsafeLogger");
		InternalLogger.setUseParentHandlers(!config.getBoolean("split"));
		InternalDebugger = Logger.getLogger("RunsafeDebugger");
		InternalDebugger.setUseParentHandlers(!config.getBoolean("split"));
		try
		{
			FileHandler logFile = new FileHandler("runsafe.log", true);
			logFile.setEncoding("UTF-8");
			logFile.setFormatter(new RunsafeLogFormatter(config.getString("format.anonymous")));
			InternalLogger.addHandler(logFile);

			FileHandler debugFile = new FileHandler("debug.log", true);
			debugFile.setEncoding("UTF-8");
			debugFile.setFormatter(new RunsafeDebugFormatter(config.getString("format.anonymous")));
			InternalDebugger.addHandler(debugFile);
		}
		catch (IOException e)
		{
		}
	}
}
