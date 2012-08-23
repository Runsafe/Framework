package no.runsafe.framework.event;

import no.runsafe.framework.event.block.*;
import no.runsafe.framework.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.event.entity.IEntityDeathEvent;
import no.runsafe.framework.event.entity.IEntityShootBowEvent;
import no.runsafe.framework.event.listener.block.*;
import no.runsafe.framework.event.listener.entity.EntityDamageByEntity;
import no.runsafe.framework.event.listener.entity.EntityDeath;
import no.runsafe.framework.event.listener.entity.EntityShootBow;
import no.runsafe.framework.event.listener.player.*;
import no.runsafe.framework.event.listener.world.*;
import no.runsafe.framework.event.player.*;
import no.runsafe.framework.event.world.*;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class EventEngine
{
	public EventEngine(IOutput output, IScheduler scheduler, List<IRunsafeEvent> events)
	{
		eventSubscribers = events;
		this.scheduler = scheduler;
		this.output = output;
	}

	@SuppressWarnings({"ConstantConditions", "deprecation"})
	public List<Listener> getListeners()
	{
		ArrayList<Listener> listeners = new ArrayList<Listener>();
		for (IRunsafeEvent sub : eventSubscribers)
		{
			if (sub instanceof IEntityDamageByEntityEvent)
				listeners.add(new EntityDamageByEntity(output, scheduler, (IEntityDamageByEntityEvent) sub));

			if (sub instanceof IPlayerChangedWorldEvent)
				listeners.add(new PlayerChangedWorld(output, scheduler, (IPlayerChangedWorldEvent) sub));

			if (sub instanceof IEntityDeathEvent)
				listeners.add(new EntityDeath(output, scheduler, (IEntityDeathEvent) sub));

			if (sub instanceof IPlayerCommandPreprocessEvent)
				listeners.add(new PlayerCommandPreprocess(output, scheduler, (IPlayerCommandPreprocessEvent) sub));

			if (sub instanceof IPlayerDropItemEvent)
				listeners.add(new PlayerDropItem(output, scheduler, (IPlayerDropItemEvent) sub));

			if (sub instanceof IPlayerLoginEvent)
				listeners.add(new PlayerLogin(output, scheduler, (IPlayerLoginEvent) sub));

			if (sub instanceof IPlayerQuitEvent)
				listeners.add(new PlayerQuit(output, scheduler, (IPlayerQuitEvent) sub));

			if (sub instanceof IPlayerTeleportEvent)
				listeners.add(new PlayerTeleport(output, scheduler, (IPlayerTeleportEvent) sub));

			if (sub instanceof IPlayerInteractEvent)
				listeners.add(new PlayerInteract(output, scheduler, (IPlayerInteractEvent) sub));

			if (sub instanceof IPlayerRightClickEvent)
				listeners.add(new PlayerRightClick(output, scheduler, (IPlayerRightClickEvent) sub));

			if (sub instanceof IPlayerLeftClickEvent)
				listeners.add(new PlayerLeftClick(output, scheduler, (IPlayerLeftClickEvent) sub));

			if (sub instanceof IPlayerChatEvent)
				listeners.add(new PlayerChat(output, scheduler, (IPlayerChatEvent) sub));

			if (sub instanceof IPlayerJoinEvent)
				listeners.add(new PlayerJoin(output, scheduler, (IPlayerJoinEvent) sub));

			if (sub instanceof IBlockBreakEvent)
				listeners.add(new BlockBreakListener(output, scheduler, (IBlockBreakEvent) sub));

			if (sub instanceof IBlockBreak)
				listeners.add(new BlockBreak(output, scheduler, (IBlockBreak) sub));

			if (sub instanceof IBlockPlaceEvent)
				listeners.add(new BlockPlaceListener(output, scheduler, (IBlockPlaceEvent) sub));

			if (sub instanceof IBlockPlace)
				listeners.add(new BlockPlace(output, scheduler, (IBlockPlace) sub));

			if (sub instanceof IBlockRedstoneEvent)
				listeners.add(new BlockRedstoneListener(output, scheduler, (IBlockRedstoneEvent) sub));

			if (sub instanceof IBlockRedstone)
				listeners.add(new BlockRedstone(output, scheduler, (IBlockRedstone) sub));

			if (sub instanceof IBlockDispenseEvent)
				listeners.add(new BlockDispenseListener(output, scheduler, (IBlockDispenseEvent) sub));

			if (sub instanceof IBlockDispense)
				listeners.add(new BlockDispense(output, scheduler, (IBlockDispense) sub));

			if (sub instanceof IEntityShootBowEvent)
				listeners.add(new EntityShootBow(output, scheduler, (IEntityShootBowEvent) sub));

			if (sub instanceof IPlayerInteractEntityEvent)
				listeners.add(new PlayerInteractEntity(output, scheduler, (IPlayerInteractEntityEvent) sub));

			if (sub instanceof IChunkLoad)
				listeners.add(new ChunkLoad(output, scheduler, (IChunkLoad) sub));

			if (sub instanceof IChunkPopulate)
				listeners.add(new ChunkPopulate(output, scheduler, (IChunkPopulate) sub));

			if (sub instanceof IChunkUnload)
				listeners.add(new ChunkUnload(output, scheduler, (IChunkUnload) sub));

			if (sub instanceof ISpawnChange)
				listeners.add(new SpawnChange(output, scheduler, (ISpawnChange) sub));

			if (sub instanceof IWorldInit)
				listeners.add(new WorldInit(output, scheduler, (IWorldInit) sub));

			if (sub instanceof IWorldLoad)
				listeners.add(new WorldLoad(output, scheduler, (IWorldLoad) sub));

			if (sub instanceof IWorldSave)
				listeners.add(new WorldSave(output, scheduler, (IWorldSave) sub));

			if (sub instanceof IWorldUnload)
				listeners.add(new WorldUnload(output, scheduler, (IWorldUnload) sub));
		}
		return listeners;
	}

	private final List<IRunsafeEvent> eventSubscribers;
	private final IScheduler scheduler;
	private final IOutput output;
}
