package no.runsafe.framework.event.server;

import org.bukkit.event.Event;

public class RunsafeEvent
{
	public RunsafeEvent(Event toWrap)
	{
		event = toWrap;
	}

	public String getEventName()
	{
		return event.getEventName();
	}

	private Event event;
}
