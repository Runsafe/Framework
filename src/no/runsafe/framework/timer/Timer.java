package no.runsafe.framework.timer;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.ITimer;
import no.runsafe.framework.internal.Minecraft;

public abstract class Timer implements ITimer, Runnable
{
	protected Timer(IScheduler scheduler, boolean async)
	{
		systemScheduler = scheduler;
		asynchronous = async;
	}

	@Override
	public void cancel()
	{
		systemScheduler.cancelTask(timerId);
	}

	@Override
	public void resetSeconds(int seconds)
	{
		resetTicks(seconds * Minecraft.TICKS_PER_SECOND);
	}

	@Override
	public void resetTicks(Long ticks)
	{
		delay = ticks;
		stop();
		start();
	}

	@Override
	public void stop()
	{
		if (timerId > 0)
			systemScheduler.cancelTask(timerId);
		timerId = 0;
	}

	@Override
	public void start()
	{
		stop();
		if (period == 0)
		{
			timerId = asynchronous
				? systemScheduler.startAsyncTask(this, delay)
				: systemScheduler.startSyncTask(this, delay);
		}
		else
		{
			timerId = asynchronous
				? systemScheduler.startAsyncRepeatingTask(this, delay, period)
				: systemScheduler.startSyncRepeatingTask(this, delay, period);
		}
	}

	@Override
	public void run()
	{
		if (period == 0)
			timerId = 0;
		OnElapsed();
	}

	public abstract void OnElapsed();

	@Override
	public boolean isDone()
	{
		return timerId <= 0;
	}

	public void setDelay(long newDelay)
	{
		delay = newDelay;
	}

	public void setPeriod(long newPeriod)
	{
		period = newPeriod;
	}

	private final IScheduler systemScheduler;
	protected long delay;
	protected long period;
	private int timerId;
	private final boolean asynchronous;
}
