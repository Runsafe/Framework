package no.runsafe.framework.timer;

public class CallbackTimer extends Timer
{
	public CallbackTimer(IScheduler scheduler, Runnable callback, long delay, long period)
	{
		super(scheduler);
		this.delay = delay;
		this.period = period;
		callbackMethod = callback;
		start();
	}

	@Override
	public void run()
	{
		callbackMethod.run();
	}

	private final Runnable callbackMethod;
}
