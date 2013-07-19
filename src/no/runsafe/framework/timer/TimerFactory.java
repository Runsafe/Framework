package no.runsafe.framework.timer;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.ITimer;

@SuppressWarnings("EmptyMethod")
public abstract class TimerFactory<T>
{
	protected TimerFactory(IScheduler scheduler)
	{
		this.scheduler = scheduler;
	}

	public final ITimer create(T state, long delay, boolean background)
	{
		ITimer timer = new CallbackTimer(scheduler, new StateHolder(this, state), delay, 0, background);
		OnTimerStarted(state);
		return timer;
	}

	/**
	 * Override this method if you have some logic you want to execute whenever a new timer is created
	 * This code will run on the main thread
	 *
	 * @param state The state object given to create
	 */
	@SuppressWarnings("NoopMethodInAbstractClass")
	public void OnTimerStarted(T state)
	{
	}

	/**
	 * Override this method to do what you want to happen after the timer period elapses.
	 * This method will be executed either on a separate thread or on the main thread, controlled by the background flag
	 * Given to the create method.
	 *
	 * @param state The state object given to create
	 */
	public abstract void OnTimerElapsed(T state);

	/**
	 * Override this method to have some code executed on the main thread after the timer finishes.
	 *
	 * @param state The state object given to create
	 */
	@SuppressWarnings("NoopMethodInAbstractClass")
	public void OnTimerCompleted(T state)
	{
	}

	private final class StateHolder implements Runnable
	{
		StateHolder(TimerFactory<T> factory, T state)
		{
			this.factory = factory;
			this.state = state;
		}

		@Override
		public void run()
		{
			factory.OnTimerElapsed(state);
			factory.ScheduleCompletion(state);
		}

		private final T state;
		private final TimerFactory<T> factory;
	}

	void ScheduleCompletion(final T state)
	{
		scheduler.startSyncTask(
			new Runnable()
			{
				@Override
				public void run()
				{
					OnTimerCompleted(state);
				}
			},
			1L
		);
	}

	private final IScheduler scheduler;
}
