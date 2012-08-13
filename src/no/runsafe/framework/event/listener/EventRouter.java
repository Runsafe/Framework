package no.runsafe.framework.event.listener;

import no.runsafe.framework.event.IAsyncEvent;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

public abstract class EventRouter<Wrapper extends IRunsafeEvent, EventType extends Event> implements Listener
{
	public EventRouter(IScheduler scheduler, Wrapper handler)
	{
		this.scheduler = scheduler;
		this.handler = handler;
		this.isAsync = (handler instanceof IAsyncEvent);
	}

	// Sadly, this method must be added to all implementing classes, but all you have to do, is call this one.
	// Don't forget to add @EventHandler - Java does not support annotations on base classes :(
	public void AcceptEvent(EventType event)
	{
		final EventType eventData = event;
		if (isAsync)
			scheduler.startAsyncTask(
				new Runnable()
				{
					@Override
					public void run()
					{
						OnEvent(eventData);
					}
				},
				0
			);
		else
			OnEvent(event);
	}

	public abstract void OnEvent(EventType event);

	protected final IScheduler scheduler;
	protected final Wrapper handler;
	private final boolean isAsync;
}
