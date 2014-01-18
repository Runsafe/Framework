package no.runsafe.framework.timer;

import no.runsafe.framework.api.IScheduler;

public class CallbackTimer extends Timer
{
	public CallbackTimer(IScheduler scheduler, Runnable callback, long delay, long period, boolean asynchronous)
	{
		super(scheduler, asynchronous);
		setDelay(delay);
		setPeriod(period);
		callbackMethod = callback;
		start();
	}

	@Override
	public void OnElapsed()
	{
		callbackMethod.run();
	}

	private final Runnable callbackMethod;
}
