package me.Kruithne.RMPF;

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
	
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IScheduler#setTimedEvent(java.lang.Runnable, java.lang.Long)
	 */
	@Override
	public void setTimedEvent(Runnable func, Long ticks)
	{
		this.server.getScheduler().scheduleSyncDelayedTask(this.plugin, func, ticks);
	}
	
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IScheduler#setTimedEvent(java.lang.Runnable, int)
	 */
	@Override
	public void setTimedEvent(Runnable func, int seconds)
	{
		this.server.getScheduler().scheduleSyncDelayedTask(this.plugin, func, seconds * 20);
	}
	
}
