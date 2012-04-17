package no.runsafe.framework.event;

import no.runsafe.framework.event.listener.entity.*;
import no.runsafe.framework.event.listener.player.*;
import no.runsafe.framework.event.entity.*;
import no.runsafe.framework.event.player.*;
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

			else if (sub instanceof IPlayerCommandPreprocessEvent)
				listeners.add(new PlayerCommandPreprocess((IPlayerCommandPreprocessEvent) sub));

			else if (sub instanceof IPlayerDropItemEvent)
				listeners.add(new PlayerDropItem((IPlayerDropItemEvent) sub));

			else if (sub instanceof IPlayerLoginEvent)
				listeners.add(new PlayerLogin((IPlayerLoginEvent) sub));

			else if (sub instanceof IPlayerQuitEvent)
				listeners.add(new PlayerQuit((IPlayerQuitEvent) sub));

			else if (sub instanceof IPlayerTeleportEvent)
				listeners.add(new PlayerTeleport((IPlayerTeleportEvent) sub));

            else if (sub instanceof IPlayerInteractEvent)
                listeners.add(new PlayerInteract((IPlayerInteractEvent) sub));
		}
		return listeners;
	}

	private List<IRunsafeEvent> eventSubscribers;
}
