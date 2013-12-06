package no.runsafe.framework.internal;

import no.runsafe.framework.api.IConsole;
import no.runsafe.framework.text.ChatColour;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("CallToPrintStackTrace")
public class Console implements IConsole
{
	protected Console(InjectionPlugin plugin)
	{
		if (plugin != null && logFormats.containsKey(plugin.getName()))
			logFormat = logFormats.get(plugin.getName());
		else if (plugin != null && logFormats.containsKey("*"))
			logFormat = String.format(logFormats.get("*"), plugin.getName());

		if (logFormat == null)
			logFormat = defaultLogFormat;

		if (plugin != null && debugFormats.containsKey(plugin.getName()))
			debugFormat = debugFormats.get(plugin.getName());
		else if (plugin != null && debugFormats.containsKey("*"))
			debugFormat = String.format(debugFormats.get("*"), plugin.getName());

		if (debugFormat == null)
			debugFormat = defaultDebugFormat;
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

	@Nullable
	@Override
	public String getLogFormat()
	{
		if (logFormat == null)
			return null;
		return ChatColour.ToConsole(logFormat);
	}

	@Nullable
	@Override
	public String getDebugFormat()
	{
		if (debugFormat == null)
			return null;
		return ChatColour.ToConsole(debugFormat);
	}

	public static String colorize(Level level)
	{
		return levelFormat.get(level);
	}

	private String logFormat = null;
	private String debugFormat = null;

	public static Level DefaultDebugLevel(String plugin)
	{
		if (defaultDebugLevel.containsKey(plugin))
			return defaultDebugLevel.get(plugin);

		return defaultDebugLevel.get("*");
	}

	protected static final Map<String, String> logFormats;
	protected static final Map<String, String> debugFormats;
	protected static final Logger InternalLogger;
	protected static final Logger InternalDebugger;

	private static String defaultLogFormat;
	private static String defaultDebugFormat;
	private static final Map<Level, String> levelFormat;
	private static final Map<String, Level> defaultDebugLevel;

	private static YamlConfiguration loadDefaults(File configFile)
	{
		YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);

		if (!config.contains("debug.*")) config.set("debug.*", "OFF");
		if (!config.contains("split")) config.set("split", false);
		if (!config.contains("format.anonymous.log")) config.set("format.anonymous.log", "%1$s %2$s [%3$s] %4$s");
		if (!config.contains("format.anonymous.debug")) config.set("format.anonymous.debug", "%1$s %2$s [&oDEBUG&r] %4$s");
		if (!config.contains("format.log.*")) config.set("format.log.*", "%%1$s %%2$s [%%3$s] [&9%s&r] %%4$s");
		if (!config.contains("format.debug.*")) config.set("format.debug.*", "%%1$s %%2$s [&oDEBUG&r] [&9%s&r] %%4$s");
		if (!config.contains("format.level"))
		{
			ConfigurationSection levels = config.createSection("format.level");
			levels.set(Level.OFF.getName(), "&8" + Level.OFF.getName() + "&r");
			levels.set(Level.SEVERE.getName(), "&4" + Level.SEVERE.getName() + "&r");
			levels.set(Level.WARNING.getName(), "&e" + Level.WARNING.getName() + "&r");
			levels.set(Level.INFO.getName(), "&2" + Level.INFO.getName() + "&r");
			levels.set(Level.CONFIG.getName(), "&3" + Level.CONFIG.getName() + "&r");
			levels.set(Level.FINE.getName(), "&a" + Level.FINE.getName() + "&r");
			levels.set(Level.FINER.getName(), "&a&l" + Level.FINER.getName() + "&r");
			levels.set(Level.FINEST.getName(), "&a&o" + Level.FINEST.getName() + "&r");
			levels.set(Level.ALL.getName(), "&f&n" + Level.ALL.getName() + "&r");
		}
		try
		{
			config.save(configFile);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		return config;
	}

	private static void configure()
	{
		YamlConfiguration config = loadDefaults(new File("runsafe", "output.yml"));

		levelFormat.putAll(castStringLevel(config.getConfigurationSection("format.level").getValues(false)));
		logFormats.putAll(castStringMap(config.getConfigurationSection("format.log").getValues(false)));
		debugFormats.putAll(castStringMap(config.getConfigurationSection("format.debug").getValues(false)));
		defaultDebugLevel.putAll(castLevelMap(config.getConfigurationSection("debug").getValues(false)));

		defaultLogFormat = config.getString("format.anonymous.log");
		defaultDebugFormat = config.getString("format.anonymous.debug");
		InternalLogger.setUseParentHandlers(!config.getBoolean("split"));
		InternalDebugger.setUseParentHandlers(!config.getBoolean("split"));
	}

	private static Map<String, String> castStringMap(Map<String, Object> data)
	{
		Map<String, String> cast = new HashMap<String, String>(data.size());
		for (Map.Entry<String, Object> entry : data.entrySet())
			cast.put(entry.getKey(), ChatColour.ToConsole(entry.getValue().toString()));
		return cast;
	}

	private static Map<String, Level> castLevelMap(Map<String, Object> data)
	{
		Map<String, Level> cast = new HashMap<String, Level>(data.size());
		for (Map.Entry<String, Object> entry : data.entrySet())
			cast.put(entry.getKey(), Level.parse(entry.getValue().toString().toUpperCase()));
		return cast;
	}

	private static Map<Level, String> castStringLevel(Map<String, Object> data)
	{
		Map<Level, String> cast = new HashMap<Level, String>(data.size());
		for (Map.Entry<String, Object> entry : data.entrySet())
			cast.put(Level.parse(entry.getKey().toUpperCase()), ChatColour.ToConsole(entry.getValue().toString()));
		return cast;
	}

	private static void startLogging(Logger log, String outputFile, Formatter formatter)
	{
		try
		{
			FileHandler logFile = new FileHandler(outputFile, true);
			logFile.setEncoding("UTF-8");
			logFile.setFormatter(new RunsafeLogFormatter());
			logFile.setFormatter(formatter);
			log.addHandler(logFile);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	static
	{
		levelFormat = new HashMap<Level, String>(1);
		defaultDebugLevel = new HashMap<String, Level>(1);
		logFormats = new HashMap<String, String>(1);
		debugFormats = new HashMap<String, String>(1);
		InternalLogger = Logger.getLogger("RunsafeLogger");
		InternalDebugger = Logger.getLogger("RunsafeDebugger");

		configure();

		startLogging(InternalLogger, "runsafe.log", new RunsafeLogFormatter());
		startLogging(InternalDebugger, "debug.log", new RunsafeDebugFormatter());
	}
}
