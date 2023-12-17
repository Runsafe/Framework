package no.runsafe.framework.internal.filesystem;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.filesystem.IPluginDataFile;
import no.runsafe.framework.api.log.IConsole;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PluginDataFile implements IPluginDataFile
{
	public PluginDataFile(RunsafePlugin plugin, String file)
	{
		pluginName = plugin.getName();
		fileName = file;
		dataFile = new File(plugin.getDataFolder(), file);
		logger = plugin.getComponent(IConsole.class);
	}

	public PluginDataFile(IConsole console, String pluginName, File dataFolder, String file)
	{
		this.pluginName = pluginName;
		fileName = file;
		dataFile = new File(dataFolder, file);
		logger = console;
	}

	@Override
	public File getRawFile()
	{
		try
		{
			fileCheck();
		}
		catch (Exception exception)
		{
			logger.logException(exception);
		}
		return dataFile;
	}

	@Override
	public List<String> getLines()
	{
		List<String> lines = new ArrayList<String>(0);

		try
		{
			fileCheck();
			BufferedReader reader = new BufferedReader(new FileReader(dataFile));
			while (true)
			{
				String line = reader.readLine();
				if (line == null)
					break;

				lines.add(line);
			}
		}
		catch (Exception exception)
		{
			logger.logException(exception);
		}

		return lines;
	}

	@Override
	public void writeLines(List<String> lines)
	{
		try
		{
			fileCheck();
			BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile));

			for (String line : lines)
			{
				writer.write(line);
				writer.newLine();
			}

			writer.close();
		}
		catch (IOException e)
		{
			logger.logException(e);
		}
	}

	private void fileCheck() throws IOException
	{
		if (!dataFile.exists())
		{
			if (!dataFile.getParentFile().isDirectory())
				throw new IOException(String.format("Plug-in data folder for %s does not exist.", pluginName));

			if (!dataFile.createNewFile())
				throw new IOException(String.format("Failed to create file %s for %s.", fileName, pluginName));
		}
	}

	private final File dataFile;
	private final String fileName;
	private final String pluginName;
	private final IConsole logger;
}
