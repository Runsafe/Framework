package no.runsafe.framework.internal.log;

import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.RunsafeLogFormatter;
import no.runsafe.framework.text.ChatColour;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogFileHandler
{
	public LogFileHandler()
	{
		levelFormat = new HashMap<Level, String>(0);
		globalLogFormat = new HashMap<String, String>(0);
		defaultDebugLevel = new HashMap<String, Level>(0);
		logFormats = new HashMap<String, Map<String, String>>(0);
		loggers = new HashMap<String, Logger>(0);

		configure();
	}

	public Level defaultDebugLevel(String plugin)
	{
		if (defaultDebugLevel.containsKey(plugin))
			return defaultDebugLevel.get(plugin);

		return defaultDebugLevel.get("*");
	}

	public String colorize(Level level)
	{
		return levelFormat.get(level);
	}

	@SuppressWarnings("OverlyBroadThrowsClause")
	public Logger getLogger(String logName, String outputFile) throws IOException
	{
		if (loggers.containsKey(outputFile))
			return loggers.get(outputFile);

		if (!logFolder.exists())
			if (!logFolder.mkdir())
				throw new IOException("Unable to create logging directory");

		File logFile = new File(logFolder, outputFile);
		if (!logFile.exists())
			if (!logFile.createNewFile())
				throw new IOException("Unable to create logfile " + logFile.getPath());

		Logger log = Logger.getLogger("_runsafe." + logName);
		FileHandler logWriter = new FileHandler(logFile.getPath(), true);
		logWriter.setEncoding("UTF-8");
		logWriter.setFormatter(new RunsafeLogFormatter(this));
		log.addHandler(logWriter);
		log.setUseParentHandlers(logToOriginalConsole);
		return log;
	}

	public String getFormat(@Nonnull InjectionPlugin plugin, @Nonnull String logName)
	{
		if (!logFormats.containsKey(logName))
			return getFormat(plugin);

		if (logFormats.get(logName).containsKey(plugin.getName()))
			return String.format(logFormats.get(logName).get(plugin.getName()), plugin.getName());

		if (logFormats.get(logName).containsKey("*"))
			return String.format(logFormats.get(logName).get("*"), plugin.getName());

		return getFormat(logName);
	}

	public String getFormat(@Nonnull InjectionPlugin plugin)
	{
		if (logFormats.get("*").containsKey(plugin.getName()))
			return String.format(logFormats.get("*").get(plugin.getName()), plugin.getName());

		return String.format(logFormats.get("*").get("*"), plugin.getName());
	}

	public String getFormat(@Nonnull String logName)
	{
		if (globalLogFormat.containsKey(logName))
			return globalLogFormat.get(logName);

		return globalLogFormat.get("*");
	}

	@SuppressWarnings({"ReturnOfNull", "HardcodedFileSeparator"})
	private YamlConfiguration loadDefaults(File configFile)
	{
		InputStream defaults = getClass().getResourceAsStream("/output.yml");
		try
		{
			YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
			config.setDefaults(YamlConfiguration.loadConfiguration(defaults));
			config.options().copyDefaults(true);
			config.save(configFile);
			return config;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		finally
		{
			try
			{
				defaults.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
		return null; // Never reached, due to system.exit above.
	}

	private void configure()
	{
		YamlConfiguration config = loadDefaults(new File("runsafe", "output.yml"));

		logToOriginalConsole = !config.getBoolean("split");
		defaultDebugLevel.putAll(castLevelMap(config.getConfigurationSection("debug").getValues(false)));

		levelFormat.putAll(castStringLevel(config.getConfigurationSection("format.level").getValues(false)));
		ConfigurationSection loggerFormats = config.getConfigurationSection("format.logger");
		for (String log : loggerFormats.getKeys(false))
			logFormats.put(log, castStringMap(loggerFormats.getConfigurationSection(log).getValues(false)));
		globalLogFormat.putAll(castStringMap(config.getConfigurationSection("format.global").getValues(false)));
	}

	private final Map<String, Map<String, String>> logFormats;
	private final Map<String, String> globalLogFormat;
	private final Map<Level, String> levelFormat;
	private final Map<String, Level> defaultDebugLevel;
	private final Map<String, Logger> loggers;
	private final File logFolder = new File("logs");
	private boolean logToOriginalConsole;

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
}
