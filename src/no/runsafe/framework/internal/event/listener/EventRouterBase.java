package no.runsafe.framework.internal.event.listener;

import no.runsafe.framework.api.event.IAsyncEvent;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

public abstract class EventRouterBase<Wrapper extends IRunsafeEvent, EventType extends Event> implements Listener
{
	protected EventRouterBase(IOutput output, IScheduler scheduler, Wrapper handler)
	{
		this.console = output;
		this.scheduler = scheduler;
		this.handler = handler;
		this.isAsync = (handler instanceof IAsyncEvent);
	}

	/**
	 * Sadly, this method must be added to all implementing classes, but all you have to do, is call this one.
	 * Don't forget to add @EventHandler - Java does not support annotations on base classes :(
	 * @param event The raw event object coming from bukkit
	 */
	public void AcceptEvent(EventType event)
	{
		if (isAsync)
			InvokeAsync(event);
		else
			Invoke(event);
	}

	/**
	 * This method is called to pass the event on to the plugin expecting it.
	 * If the subscriber doesn't implement IAsyncEvent and the event is Cancellable,
	 * returning false from here will cancel the event.
	 *
	 * @param event The raw event object from bukkit
	 * @return false to cancel a cancellable event
	 */
	public abstract boolean OnEvent(EventType event);

	private void InvokeAsync(final EventType event)
	{
		scheduler.startAsyncTask(
			new Runnable()
			{
				@Override
				public void run()
				{
					Invoke(event);
				}
			},
			0
		);
	}

	private void Invoke(EventType event)
	{
		try
		{
			boolean result = OnEvent(event);
			if (!result && event instanceof Cancellable)
				((Cancellable) event).setCancelled(true);
		}
		catch (Exception e)
		{
			console.logException(e);
		}
	}

	protected final IScheduler scheduler;
	protected final Wrapper handler;
	private final boolean isAsync;
	private final IOutput console;
}
