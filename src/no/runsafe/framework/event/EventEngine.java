package no.runsafe.framework.event;

import no.runsafe.framework.entity.event.EntityDamageByEntity;
import no.runsafe.framework.entity.event.EntityDeath;
import no.runsafe.framework.entity.event.IEntityDamageByEntityEvent;
import no.runsafe.framework.entity.event.IEntityDeathEvent;
import no.runsafe.framework.player.event.IPlayerChangedWorldEvent;
import no.runsafe.framework.player.event.PlayerChangedWorld;
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
		for (IRunsafeEvent sub : eventSubscribers) {
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
