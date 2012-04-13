package no.runsafe.framework.timer;

public abstract class Timer implements ITimer, Runnable
{
	public Timer(IScheduler scheduler)
	{
		systemScheduler = scheduler;
	}

	@Override
	public void Cancel()
	{
		systemScheduler.cancelTask(timerId);
	}

	@Override
	public void ResetSeconds(int seconds)
	{
		ResetTicks((long)seconds * 20);
	}

	@Override
	public void ResetTicks(Long ticks)
	{
		delay = ticks;
		stop();
		start();
	}

	@Override
	public void stop()
	{
		if(timerId > 0)
			systemScheduler.cancelTask(timerId);
	}

	@Override
	public void start()
	{
		stop();
		if(period == 0)
		{
			this.timerId = systemScheduler.startSyncTask(this, delay);
		}
		else
		{
			this.timerId = systemScheduler.startSyncRepeatingTask(this, delay, period);
		}
	}

	private IScheduler systemScheduler;
	protected long delay;
	protected long period;
	private int timerId;
}
