package no.runsafe.framework.timer;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.ITimer;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.Minecraft;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

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

	/**
	 * @param func A function to run immediately
	 */
	@Override
	public void runNow(Runnable func)
	{
		scheduler.runTask(
			plugin,
			() -> {
				try
				{
					func.run();
				}
				catch (Exception e)
				{
					console.logException(e);
				}
			}
		);
	}

	/*public void runNow(Runnable func, Consumer<Boolean> callback)
	{
		scheduler.runTask(
			plugin,
			() -> {
				try
				{
					func.run();
					callback.accept(true);
					return;
				}
				catch (Exception e)
				{
					console.logException(e);
				}
				callback.accept(false);
			}
		);
	}*/

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
	public void createSyncTimer(Runnable func, int seconds)
	{
		createSyncTimer(func, seconds, 0);
	}

	@Override
	public void createSyncTimer(Runnable func, int delay, int period)
	{
		createSyncTimer(func, delay * Minecraft.TICKS_PER_SECOND, period * Minecraft.TICKS_PER_SECOND);
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
	public void createAsyncTimer(Runnable func, int seconds)
	{
		createAsyncTimer(func, seconds, 0);
	}

	@Override
	public void createAsyncTimer(Runnable func, int delay, int period)
	{
		createAsyncTimer(func, delay * Minecraft.TICKS_PER_SECOND, period * Minecraft.TICKS_PER_SECOND);
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
