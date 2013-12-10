package no.runsafe.framework.internal.log;

import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.RunsafeLogFormatter;
import no.runsafe.framework.text.ChatColour;
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

public abstract class LoggingBase implements ILogFormatProvider
{
	protected LoggingBase(InjectionPlugin plugin)
	{
		logType = getClass().getSimpleName();
		if (plugin != null && logFormats.get(logType).containsKey(plugin.getName()))
			logFormat = logFormats.get(logType).get(plugin.getName());
		else if (plugin != null && logFormats.get(logType).containsKey("*"))
			logFormat = String.format(logFormats.get(logType).get("*"), plugin.getName());
		else
			logFormat = defaultLogFormat.get(logType);
	}

	protected void writeLog(Level level, String message)
	{
		Logs.get(logType).log(level, message, this);
	}

	@Override
	@Nullable
	public String getLogFormat()
	{
		if (logFormat == null)
			return "%1$s %2$s [%3$s] %4$s";
		return ChatColour.ToConsole(logFormat);
	}

	private final String logType;
	private final String logFormat;

	public static Level DefaultDebugLevel(String plugin)
	{
		if (defaultDebugLevel.containsKey(plugin))
			return defaultDebugLevel.get(plugin);

		return defaultDebugLevel.get("*");
	}

	public static String colorize(Level level)
	{
		return levelFormat.get(level);
	}

	private static final Map<String, Map<String, String>> logFormats;
	private static final Map<String, Logger> Logs;
	private static final Map<String, String> defaultLogFormat;
	private static final Map<Level, String> levelFormat;
	private static final Map<String, Level> defaultDebugLevel;
	private static final File logFolder = new File("logs");

	private static YamlConfiguration loadDefaults(File configFile)
	{
		YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);

		if (!config.contains("debug.*")) config.set("debug.*", "OFF");
		if (!config.contains("split")) config.set("split", false);
		if (!config.contains("format.anonymous.Console")) config.set("format.anonymous.Console", "%1$s %2$s [%3$s] %4$s");
		if (!config.contains("format.anonymous.Broadcaster")) config.set("format.anonymous.Broadcaster", "%1$s %2$s [%3$s] %4$s");
		if (!config.contains("format.anonymous.Debug")) config.set("format.anonymous.Debug", "%1$s %2$s [&oDEBUG&r] %4$s");
		if (!config.contains("format.anonymous.Protocol"))
			config.set("format.anonymous.Protocol", "%1$s %2$s [&nNET&r] %4$s");
		if (!config.contains("format.Console.*")) config.set("format.Console.*", "%%1$s %%2$s [%%3$s] [&9%s&r] %%4$s");
		if (!config.contains("format.Broadcaster.*")) config.set("format.Broadcaster.*", "%%1$s %%2$s [%%3$s] [&9%s&r] %%4$s");
		if (!config.contains("format.Debug.*")) config.set("format.Debug.*", "%%1$s %%2$s [&oDEBUG&r] [&9%s&r] %%4$s");
		if (!config.contains("format.Protocol.*")) config.set("format.Protocol.*", "%%1$s %%2$s [&nNET&r] [&9%s&r] %%4$s");
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

		boolean sendToBukkit = !config.getBoolean("split");
		defaultDebugLevel.putAll(castLevelMap(config.getConfigurationSection("debug").getValues(false)));
		levelFormat.putAll(castStringLevel(config.getConfigurationSection("format.level").getValues(false)));
		for (Map.Entry<String, Logger> stringLoggerEntry : Logs.entrySet())
		{
			logFormats.put(stringLoggerEntry.getKey(), castStringMap(config.getConfigurationSection("format." + stringLoggerEntry.getKey()).getValues(false)));
			defaultLogFormat.put(stringLoggerEntry.getKey(), config.getString("format.anonymous." + stringLoggerEntry.getKey()));
			stringLoggerEntry.getValue().setUseParentHandlers(sendToBukkit);
		}
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

	private static void startLogging(Logger log, String outputFile, Formatter formatter) throws IOException
	{
		if (!logFolder.exists())
			if (!logFolder.mkdir())
				throw new IOException("Unable to create logging directory");

		File logFile = new File(logFolder, outputFile);
		if (!logFile.exists())
			if (!logFile.createNewFile())
				throw new IOException("Unable to create logfile " + logFile.getPath());

		FileHandler logWriter = new FileHandler(logFile.getPath(), true);
		logWriter.setEncoding("UTF-8");
		logWriter.setFormatter(formatter);
		log.addHandler(logWriter);
	}

	static
	{
		levelFormat = new HashMap<Level, String>(1);
		defaultLogFormat = new HashMap<String, String>(3);
		defaultDebugLevel = new HashMap<String, Level>(1);
		logFormats = new HashMap<String, Map<String, String>>(3);
		Logs = new HashMap<String, Logger>(3);
		Logs.put("Console", Logger.getLogger("RunsafeLogger"));
		Logs.put("Broadcaster", Logger.getLogger("RunsafeBroadcaster"));
		Logs.put("Debug", Logger.getLogger("RunsafeDebugger"));
		Logs.put("Protocol", Logger.getLogger("RunsafeProtocol"));

		configure();

		try
		{
			startLogging(Logs.get("Console"), "runsafe.log", new RunsafeLogFormatter());
			startLogging(Logs.get("Broadcaster"), "broadcast.log", new RunsafeLogFormatter());
			startLogging(Logs.get("Debug"), "debug.log", new RunsafeLogFormatter());
			startLogging(Logs.get("Protocol"), "protocol.log", new RunsafeLogFormatter());
		}
		// If this fails, we can't log the normal way, so we panic!
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
}
