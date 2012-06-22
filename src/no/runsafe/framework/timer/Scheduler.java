package no.runsafe.framework.timer;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Scheduler implements IScheduler
{

	private final Plugin plugin;
	private final BukkitScheduler scheduler;

	public Scheduler(Server server, Plugin plugin)
	{
		scheduler = server.getScheduler();
		this.plugin = plugin;
	}

	@Override
	public int startSyncTask(Runnable func, Long ticks)
	{
		return this.scheduler.scheduleSyncDelayedTask(this.plugin, func, ticks);
	}

	@Override
	public int startSyncTask(Runnable func, int seconds)
	{
		return this.startSyncTask(func, (long) seconds * 20);
	}

	@Override
	public int startSyncRepeatingTask(Runnable func, int delay, int period)
	{
		return this.startSyncRepeatingTask(func, (long) delay * 20, (long) period * 20);
	}

	@Override
	public int startSyncRepeatingTask(Runnable func, long delay, long period)
	{
		return this.scheduler.scheduleSyncRepeatingTask(this.plugin, func, delay, period);
	}

	@Override
	public void cancelTask(int eventId)
	{
		if(this.scheduler.isQueued(eventId))
			this.scheduler.cancelTask(eventId);
	}

	@Override
	public ITimer createSyncTimer(Runnable func, int seconds)
	{
		return createSyncTimer(func, seconds, 0);
	}

	@Override
	public ITimer createSyncTimer(Runnable func, int delay, int period)
	{
		return createSyncTimer(func, (long) delay * 20, (long) period * 20);
	}

	@Override
	public ITimer createSyncTimer(Runnable func, Long delay)
	{
		return createSyncTimer(func, delay, 0L);
	}

	@Override
	public ITimer createSyncTimer(Runnable func, Long delay, Long period)
	{
		return new CallbackTimer(this, func, delay, period);
	}
}
