package no.runsafe.framework.internal.log;

import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.RunsafeDebugFormatter;
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

public abstract class Log
{
	protected Log(InjectionPlugin plugin)
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

	@Nullable
	public String getLogFormat()
	{
		if (logFormat == null)
			return null;
		return ChatColour.ToConsole(logFormat);
	}

	@Nullable
	public String getDebugFormat()
	{
		if (debugFormat == null)
			return null;
		return ChatColour.ToConsole(debugFormat);
	}

	private String logFormat = null;
	private String debugFormat = null;

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

	protected static final Map<String, String> logFormats;
	protected static final Map<String, String> debugFormats;
	protected static final Map<String, Logger> Logs;

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
		boolean sendToBukkit = !config.getBoolean("split");
		for(Logger log : Logs.values())
			log.setUseParentHandlers(sendToBukkit);
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
			FileHandler logFile = new FileHandler(new File("logs", outputFile).getPath(), true);
			logFile.setEncoding("UTF-8");
			logFile.setFormatter(new RunsafeLogFormatter());
			logFile.setFormatter(formatter);
			log.addHandler(logFile);
		}
		// If this fails, we can't log the normal way, so we panic!
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
		Logs = new HashMap<String, Logger>(3);
		Logs.put("Console", Logger.getLogger("RunsafeLogger"));
		Logs.put("Debug", Logger.getLogger("RunsafeDebugger"));
		Logs.put("Protocol", Logger.getLogger("RunsafeProtocol"));

		configure();

		startLogging(Logs.get("Console"), "runsafe.log", new RunsafeLogFormatter());
		startLogging(Logs.get("Debug"), "debug.log", new RunsafeDebugFormatter());
		startLogging(Logs.get("Protocol"), "protocol.log", new RunsafeDebugFormatter());
	}
}
