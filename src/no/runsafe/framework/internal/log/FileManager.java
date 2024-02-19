package no.runsafe.framework.internal.log;

import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.configuration.FrameworkConfiguration;
import no.runsafe.framework.text.ChatColour;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class FileManager
{
	public FileManager(FrameworkConfiguration config)
	{
		levelFormat = new HashMap<>(0);
		globalLogFormat = new HashMap<>(0);
		defaultDebugLevel = new HashMap<>(0);
		logFormats = new HashMap<>(0);

		configure(config);
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
	public Logger getLogger(String outputFile) throws IOException
	{
		if (loggers.containsKey(outputFile))
			return loggers.get(outputFile);

		File logFile = getLogFile(outputFile);
		Logger log = Logger.getLogger("runsafe." + outputFile);
		log.setUseParentHandlers(logToOriginalConsole);
		loggers.put(outputFile, log);
		FileHandler logWriter = new FileHandler(logFile.getPath(), true);
		logWriter.setEncoding("UTF-8");
		logWriter.setFormatter(new RunsafeLogFormatter(this));
		log.addHandler(logWriter);
		return log;
	}

	private File getLogFile(String outputFile) throws IOException
	{
		File logFile = new File(logFolder, outputFile);
		if (!logFile.exists())
			createFile(logFile);
		return logFile;
	}

	private void createFile(File logFile) throws IOException
	{
		if (!logFolder.exists())
			if (!logFolder.mkdir())
				throw new IOException("Unable to create logging directory");

		if (!logFile.createNewFile())
			throw new IOException("Unable to create logfile " + logFile.getPath());
	}

	public String getFormat(@Nonnull InjectionPlugin plugin, @Nonnull String logName)
	{
		if (!logFormats.containsKey(logName))
			return getFormat(plugin);

		if (logFormats.get(logName).containsKey(plugin.getName()))
			return logFormats.get(logName).get(plugin.getName());

		if (logFormats.get(logName).containsKey("*"))
			return String.format(logFormats.get(logName).get("*"), plugin.getName());

		return getFormat(logName);
	}

	public String getFormat(@Nonnull InjectionPlugin plugin)
	{
		if (logFormats.get("*").containsKey(plugin.getName()))
			return logFormats.get("*").get(plugin.getName());

		return String.format(logFormats.get("*").get("*"), plugin.getName());
	}

	public String getFormat(@Nonnull String logName)
	{
		if (globalLogFormat.containsKey(logName))
			return globalLogFormat.get(logName);

		return globalLogFormat.get("*");
	}

	private void configure(FrameworkConfiguration config)
	{
		String logFolderString = config.getConfigValueAsString("output.folder");

		if (logFolderString == null)
		{
			System.out.print("output.folder missing from config.yml");
			System.exit(1);
		}

		logFolder = new File(logFolderString);
		if (!logFolder.exists())
			if (!logFolder.mkdir())
			{
				System.out.printf("Unable to create logging folder at %s", logFolder.getPath());
				System.exit(1);
			}
		logToOriginalConsole = !config.getConfigValueAsBoolean("output.split");

		Map<String, String> debug = config.getConfigValuesAsMap("output.debug");
		if (debug != null)
			defaultDebugLevel.putAll(castLevelMap(debug));

		Map<String, String> level = config.getConfigValuesAsMap("output.format.level");
		if (level != null)
			levelFormat.putAll(castStringLevel(level));

		Map<String, Map<String, String>> logger = config.getConfigSectionsAsMap("output.format.logger");
		if (logger != null)
			logFormats.putAll(logger);

		Map<String, String> global = config.getConfigValuesAsMap("output.format.global");
		if (global != null)
			globalLogFormat.putAll(global);
	}

	private final Map<String, Map<String, String>> logFormats;
	private final Map<String, String> globalLogFormat;
	private final Map<Level, String> levelFormat;
	private final Map<String, Level> defaultDebugLevel;
	private final Map<String, Logger> loggers = new ConcurrentHashMap<>();
	private boolean logToOriginalConsole;
	private File logFolder;

	private static Map<String, Level> castLevelMap(Map<String, String> data)
	{
		Map<String, Level> cast = new HashMap<>(data.size());
		for (Map.Entry<String, String> entry : data.entrySet())
			cast.put(entry.getKey(), Level.parse(entry.getValue().toUpperCase()));
		return cast;
	}

	private static Map<Level, String> castStringLevel(Map<String, String> data)
	{
		Map<Level, String> cast = new HashMap<>(data.size());
		for (Map.Entry<String, String> entry : data.entrySet())
			cast.put(Level.parse(entry.getKey().toUpperCase()), ChatColour.ToConsole(entry.getValue()));
		return cast;
	}
}
