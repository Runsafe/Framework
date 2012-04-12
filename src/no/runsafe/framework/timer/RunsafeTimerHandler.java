package no.runsafe.framework.timer;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

public class RunsafeTimerHandler implements IScheduler {

	private Plugin plugin;
	private Server server;

	public RunsafeTimerHandler(Server server, Plugin plugin)
	{
		this.server = server;
		this.plugin = plugin;
	}
	
	@Override
	public int setTimedEvent(Runnable func, Long ticks)
	{
		return this.server.getScheduler().scheduleSyncDelayedTask(this.plugin, func, ticks);
	}

	@Override
	public int setTimedEvent(Runnable func, int seconds)
	{
		return this.setTimedEvent(func, (long)seconds * 20);
		//this.server.getScheduler().scheduleSyncDelayedTask(this.plugin, func, seconds * 20);
	}

	@Override
	public void cancelTimedEvent(int eventId)
	{
		this.server.getScheduler().cancelTask(eventId);
	}
}
