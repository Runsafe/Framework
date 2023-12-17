package no.runsafe.framework.minecraft.event;

import org.bukkit.event.Event;

public class RunsafeEvent
{
	protected RunsafeEvent(Event toWrap)
	{
		event = toWrap;
	}

	public String getEventName()
	{
		return event.getEventName();
	}

	private final Event event;
}
