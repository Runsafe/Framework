package no.runsafe.framework.event;

import no.runsafe.framework.event.block.IBlockBreakEvent;
import no.runsafe.framework.event.block.IBlockDispenseEvent;
import no.runsafe.framework.event.block.IBlockPlaceEvent;
import no.runsafe.framework.event.block.IBlockRedstoneEvent;
import no.runsafe.framework.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.event.entity.IEntityDeathEvent;
import no.runsafe.framework.event.entity.IEntityShootBowEvent;
import no.runsafe.framework.event.listener.block.BlockBreak;
import no.runsafe.framework.event.listener.block.BlockDispense;
import no.runsafe.framework.event.listener.block.BlockPlace;
import no.runsafe.framework.event.listener.block.BlockRedstone;
import no.runsafe.framework.event.listener.entity.EntityDamageByEntity;
import no.runsafe.framework.event.listener.entity.EntityDeath;
import no.runsafe.framework.event.listener.entity.EntityShootBow;
import no.runsafe.framework.event.listener.player.*;
import no.runsafe.framework.event.player.*;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class EventEngine
{
	public EventEngine(IScheduler scheduler, List<IRunsafeEvent> events)
	{
		eventSubscribers = events;
		this.scheduler = scheduler;
	}

	@SuppressWarnings("ConstantConditions")
	public List<Listener> getListeners()
	{
		ArrayList<Listener> listeners = new ArrayList<Listener>();
		for (IRunsafeEvent sub : eventSubscribers)
		{
			if (sub instanceof IEntityDamageByEntityEvent)
				listeners.add(new EntityDamageByEntity(scheduler, (IEntityDamageByEntityEvent) sub));

			if (sub instanceof IPlayerChangedWorldEvent)
				listeners.add(new PlayerChangedWorld(scheduler, (IPlayerChangedWorldEvent) sub));

			if (sub instanceof IEntityDeathEvent)
				listeners.add(new EntityDeath(scheduler, (IEntityDeathEvent) sub));

			if (sub instanceof IPlayerCommandPreprocessEvent)
				listeners.add(new PlayerCommandPreprocess(scheduler, (IPlayerCommandPreprocessEvent) sub));

			if (sub instanceof IPlayerDropItemEvent)
				listeners.add(new PlayerDropItem(scheduler, (IPlayerDropItemEvent) sub));

			if (sub instanceof IPlayerLoginEvent)
				listeners.add(new PlayerLogin(scheduler, (IPlayerLoginEvent) sub));

			if (sub instanceof IPlayerQuitEvent)
				listeners.add(new PlayerQuit(scheduler, (IPlayerQuitEvent) sub));

			if (sub instanceof IPlayerTeleportEvent)
				listeners.add(new PlayerTeleport(scheduler, (IPlayerTeleportEvent) sub));

			if (sub instanceof IPlayerInteractEvent)
				listeners.add(new PlayerInteract(scheduler, (IPlayerInteractEvent) sub));

			if (sub instanceof IPlayerRightClickEvent)
				listeners.add(new PlayerRightClick(scheduler, (IPlayerRightClickEvent) sub));

			if (sub instanceof IPlayerLeftClickEvent)
				listeners.add(new PlayerLeftClick(scheduler, (IPlayerLeftClickEvent) sub));

			if (sub instanceof IPlayerChatEvent)
				listeners.add(new PlayerChat(scheduler, (IPlayerChatEvent) sub));

			if (sub instanceof IPlayerJoinEvent)
				listeners.add(new PlayerJoin(scheduler, (IPlayerJoinEvent) sub));

			if (sub instanceof IBlockBreakEvent)
				listeners.add(new BlockBreak(scheduler, (IBlockBreakEvent) sub));

			if (sub instanceof IBlockPlaceEvent)
				listeners.add(new BlockPlace(scheduler, (IBlockPlaceEvent) sub));

			if (sub instanceof IBlockRedstoneEvent)
				listeners.add(new BlockRedstone(scheduler, (IBlockRedstoneEvent) sub));

			if (sub instanceof IBlockDispenseEvent)
				listeners.add(new BlockDispense(scheduler, (IBlockDispenseEvent) sub));

			if (sub instanceof IEntityShootBowEvent)
				listeners.add(new EntityShootBow(scheduler, (IEntityShootBowEvent) sub));

			if (sub instanceof IPlayerInteractEntityEvent)
				listeners.add(new PlayerInteractEntity(scheduler, (IPlayerInteractEntityEvent) sub));
		}
		return listeners;
	}

	private final List<IRunsafeEvent> eventSubscribers;
	private final IScheduler scheduler;
}
