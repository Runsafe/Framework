package me.Kruithne.RMPF;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

public class RMPFTimedEventHandler {

	private Plugin plugin;
	private Server server;

	public RMPFTimedEventHandler(Server server, Plugin plugin)
	{
		this.server = server;
		this.plugin = plugin;
	}
	
	public void setTimedEvent(Runnable func, Long ticks)
	{
		this.server.getScheduler().scheduleSyncDelayedTask(this.plugin, func, ticks);
	}
	
	public void setTimedEvent(Runnable func, int seconds)
	{
		this.server.getScheduler().scheduleSyncDelayedTask(this.plugin, func, seconds * 20);
	}
	
}
