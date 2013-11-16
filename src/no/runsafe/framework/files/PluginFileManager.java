package no.runsafe.framework.files;

import no.runsafe.framework.RunsafePlugin;

public class PluginFileManager
{
	public PluginFileManager(RunsafePlugin plugin)
	{
		this.plugin = plugin;
	}

	public PluginDataFile getFile(String file)
	{
		return new PluginDataFile(plugin, file);
	}

	private final RunsafePlugin plugin;
}
