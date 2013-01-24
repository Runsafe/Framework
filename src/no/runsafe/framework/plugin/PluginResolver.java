package no.runsafe.framework.plugin;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

@Deprecated
public class PluginResolver
{
	public PluginResolver(Server server)
	{
		bukkitServer = server;
	}

	@SuppressWarnings("unchecked")
	public <T extends Plugin> T getPlugin(String name)
	{
		Plugin plugin = bukkitServer.getPluginManager().getPlugin(name);
		if (plugin == null)
			return null;

		return (T) plugin;
	}

	private final Server bukkitServer;
}
