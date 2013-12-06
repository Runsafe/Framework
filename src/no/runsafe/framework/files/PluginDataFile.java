package no.runsafe.framework.files;

import no.runsafe.framework.RunsafePlugin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PluginDataFile
{
	public PluginDataFile(RunsafePlugin plugin, String file)
	{
		pluginName = plugin.getName();
		fileName = file;
		dataFile = new File(plugin.getDataFolder(), file);
		logger = plugin.getLogger();
	}

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
			logger.warning(exception.getMessage());
		}

		return lines;
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
	private final Logger logger;
}
