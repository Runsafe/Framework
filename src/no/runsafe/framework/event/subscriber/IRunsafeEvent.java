package no.runsafe.framework.event.subscriber;

import org.bukkit.event.Event;

public interface IRunsafeEvent
{
	public abstract void Handle(Event event);
}
