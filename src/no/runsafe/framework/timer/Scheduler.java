package no.runsafe.framework.timer;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.ITimer;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.Minecraft;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

@SuppressWarnings("deprecation")
public class Scheduler implements IScheduler
{
	public Scheduler(BukkitScheduler scheduler, JavaPlugin plugin, IConsole console)
	{
		this.scheduler = scheduler;
		this.plugin = plugin;
		this.console = console;
	}

	@Override
	public int startSyncTask(Runnable func, Long ticks)
	{
		return scheduler.scheduleSyncDelayedTask(plugin, func, ticks);
	}

	@Override
	public int startSyncTask(Runnable func, int seconds)
	{
		return startSyncTask(func, seconds * Minecraft.TICKS_PER_SECOND);
	}

	public boolean runNow(Runnable func)
	{
		try
		{
			scheduler.runTask(plugin, func).wait();
			return true;
		}
		catch (InterruptedException e)
		{
			console.logException(e);
			return false;
		}
	}

	@Override
	public int startSyncRepeatingTask(Runnable func, int delay, int period)
	{
		return startSyncRepeatingTask(func, delay * Minecraft.TICKS_PER_SECOND, period * Minecraft.TICKS_PER_SECOND);
	}

	@Override
	public int startSyncRepeatingTask(Runnable func, long delay, long period)
	{
		return scheduler.scheduleSyncRepeatingTask(plugin, func, delay, period);
	}

	@Override
	public ITimer createSyncTimer(Runnable func, int seconds)
	{
		return createSyncTimer(func, seconds, 0);
	}

	@Override
	public ITimer createSyncTimer(Runnable func, int delay, int period)
	{
		return createSyncTimer(func, delay * Minecraft.TICKS_PER_SECOND, period * Minecraft.TICKS_PER_SECOND);
	}

	@Override
	public ITimer createSyncTimer(Runnable func, Long ticks)
	{
		return createSyncTimer(func, ticks, 0L);
	}

	@Override
	public ITimer createSyncTimer(Runnable func, Long delay, Long period)
	{
		return new CallbackTimer(this, func, delay, period, false);
	}

	@Override
	public ITimer createAsyncTimer(Runnable func, int seconds)
	{
		return createAsyncTimer(func, seconds, 0);
	}

	@Override
	public ITimer createAsyncTimer(Runnable func, int delay, int period)
	{
		return createAsyncTimer(func, delay * Minecraft.TICKS_PER_SECOND, period * Minecraft.TICKS_PER_SECOND);
	}

	@Override
	public ITimer createAsyncTimer(Runnable func, Long ticks)
	{
		return createAsyncTimer(func, ticks, 0L);
	}

	@Override
	public ITimer createAsyncTimer(Runnable func, Long delay, Long period)
	{
		return new CallbackTimer(this, func, delay, period, true);
	}

	@Override
	public void cancelTask(int eventId)
	{
		if (scheduler.isQueued(eventId))
			scheduler.cancelTask(eventId);
	}

	@Override
	@Deprecated
	public int startAsyncTask(Runnable func, Long ticks)
	{
		return scheduler.scheduleAsyncDelayedTask(plugin, func, ticks);
	}

	@Override
	@Deprecated
	public int startAsyncTask(Runnable func, int seconds)
	{
		return startAsyncTask(func, seconds * Minecraft.TICKS_PER_SECOND);
	}

	@Override
	@Deprecated
	public int startAsyncRepeatingTask(Runnable func, long delay, long period)
	{
		return scheduler.scheduleAsyncRepeatingTask(plugin, func, delay, period);
	}

	private final JavaPlugin plugin;
	private final BukkitScheduler scheduler;
	private final IConsole console;
}
