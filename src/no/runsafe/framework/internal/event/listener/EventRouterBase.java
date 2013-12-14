package no.runsafe.framework.internal.event.listener;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IAsyncEvent;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.log.IConsole;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;

public abstract class EventRouterBase<Wrapper extends IRunsafeEvent, EventType extends Event> implements Listener
{
	protected EventRouterBase(IConsole output, IScheduler scheduler, Wrapper handler)
	{
		console = output;
		this.scheduler = scheduler;
		this.handler = handler;
		isAsync = handler instanceof IAsyncEvent;
	}

	/**
	 * Sadly, this method must be added to all implementing classes, but all you have to do, is call this one.
	 * Don't forget to add @EventHandler - Java does not support annotations on base classes :(
	 *
	 * @param event The raw event object coming from bukkit
	 */
	protected void acceptEvent(EventType event)
	{
		if (isAsync)
			invokeAsync(event);
		else
			invoke(event);
	}

	/**
	 * This method is called to pass the event on to the plugin expecting it.
	 * If the subscriber doesn't implement IAsyncEvent and the event is Cancellable,
	 * returning false from here will cancel the event.
	 *
	 * @param event The raw event object from bukkit
	 * @return true to cancel a cancellable event
	 */
	protected abstract boolean onEvent(EventType event);

	private void invokeAsync(final EventType event)
	{
		scheduler.startAsyncTask(
			new Runnable()
			{
				@Override
				public void run()
				{
					invoke(event);
				}
			},
			0
		);
	}

	private void invoke(EventType event)
	{
		try
		{
			boolean cancelled = onEvent(event);
			if (cancelled && event instanceof Cancellable)
				((Cancellable) event).setCancelled(true);
		}
		catch (Exception e)
		{
			if (event instanceof PlayerEvent && ((PlayerEvent) event).getPlayer() != null)
				console.logInformation("PlayerExtensions %s caused an exception:", ((PlayerEvent) event).getPlayer().getName());
			console.logException(e);
		}
	}

	private final IScheduler scheduler;
	protected final Wrapper handler;
	private final boolean isAsync;
	private final IConsole console;
}
