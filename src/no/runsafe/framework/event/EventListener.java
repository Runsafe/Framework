package no.runsafe.framework.event;

import no.runsafe.framework.event.subscriber.IRunsafeEvent;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public abstract class EventListener<TSub extends IRunsafeEvent, TEvent extends Event> implements Listener
{
	protected EventListener(TSub sub)
	{
		eventSubscriber = sub;
	}

	@EventHandler
	public abstract void OnEvent(TEvent event);

	protected TSub eventSubscriber;
}
