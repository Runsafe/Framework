package no.runsafe.framework.event;

import no.runsafe.framework.event.listener.entity.EntityDamageByEntity;
import no.runsafe.framework.event.listener.entity.EntityDeath;
import no.runsafe.framework.event.listener.player.PlayerChangedWorld;
import no.runsafe.framework.event.subscriber.IRunsafeEvent;
import no.runsafe.framework.event.subscriber.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.event.subscriber.entity.IEntityDeathEvent;
import no.runsafe.framework.event.subscriber.player.IPlayerChangedWorldEvent;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class EventEngine
{
	public EventEngine(List<IRunsafeEvent> events)
	{
		eventSubscribers = events;
	}

	public List<Listener> getListeners()
	{
		ArrayList<Listener> listeners = new ArrayList<Listener>();
		for (IRunsafeEvent sub : eventSubscribers)
		{
			if (sub instanceof IEntityDamageByEntityEvent)
				listeners.add(new EntityDamageByEntity((IEntityDamageByEntityEvent) sub));

			else if (sub instanceof IPlayerChangedWorldEvent)
				listeners.add(new PlayerChangedWorld((IPlayerChangedWorldEvent) sub));

			else if (sub instanceof IEntityDeathEvent)
				listeners.add(new EntityDeath((IEntityDeathEvent) sub));
		}
		return listeners;
	}

	private List<IRunsafeEvent> eventSubscribers;
}
