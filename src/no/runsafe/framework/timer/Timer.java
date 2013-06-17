package no.runsafe.framework.timer;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.ITimer;

public abstract class Timer implements ITimer, Runnable
{
	public Timer(IScheduler scheduler, boolean async)
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
		resetTicks((long) seconds * 20);
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
			if (asynchronous)
				this.timerId = systemScheduler.startAsyncTask(this, delay);
			else
				this.timerId = systemScheduler.startSyncTask(this, delay);
		}
		else
		{
			if (asynchronous)
				this.timerId = systemScheduler.startAsyncRepeatingTask(this, delay, period);
			else
				this.timerId = systemScheduler.startSyncRepeatingTask(this, delay, period);
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
	public boolean isRunning()
	{
		return timerId > 0;
	}

	private final IScheduler systemScheduler;
	protected long delay;
	protected long period;
	private int timerId;
	private final boolean asynchronous;
}
