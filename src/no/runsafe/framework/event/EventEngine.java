package no.runsafe.framework.event;

import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.listener.block.*;
import no.runsafe.framework.event.listener.entity.*;
import no.runsafe.framework.event.listener.player.*;
import no.runsafe.framework.event.listener.world.*;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class EventEngine
{
	// Call Register on all even listeners here
	static
	{
		factories = new HashMap<Class<? extends IRunsafeEvent>, EventRouterFactory>();

		// Block events
		BlockBreak.Register();
		BlockBreakListener.Register();
		BlockDispense.Register();
		BlockDispenseListener.Register();
		BlockPlace.Register();
		BlockPlaceListener.Register();
		BlockRedstone.Register();
		BlockRedstoneListener.Register();
		SignChange.Register();

		// Entity events
		CreatureSpawn.Register();
		EntityDamageByEntity.Register();
		EntityDeath.Register();
		EntityShootBow.Register();
		SpawnEggUsed.Register();

		// Player events
		PlayerChangedWorld.Register();
		PlayerChat.Register();
		PlayerCommandPreprocess.Register();
		PlayerDeath.Register();
		PlayerDropItem.Register();
		PlayerInteract.Register();
		PlayerInteractEntity.Register();
		PlayerJoin.Register();
		PlayerKick.Register();
		PlayerLeftClick.Register();
		PlayerLogin.Register();
		PlayerMove.Register();
		PlayerPreLogin.Register();
		PlayerQuit.Register();
		PlayerRightClick.Register();
		PlayerRightClickListener.Register();
		PlayerRightClickSign.Register();
		PlayerTeleport.Register();

		// World events
		ChunkLoad.Register();
		ChunkPopulate.Register();
		ChunkUnload.Register();
		SpawnChange.Register();
		WorldInit.Register();
		WorldLoad.Register();
		WorldSave.Register();
		WorldUnload.Register();
	}

	public EventEngine(IOutput output, IScheduler scheduler, List<IRunsafeEvent> events)
	{
		eventSubscribers = events;
		this.scheduler = scheduler;
		this.output = output;
	}

	public List<Listener> getListeners()
	{
		ArrayList<Listener> listeners = new ArrayList<Listener>();
		for (IRunsafeEvent sub : eventSubscribers)
			listeners.addAll(getRouters(sub));
		return listeners;
	}

	public static void Register(Class<? extends IRunsafeEvent> type, EventRouterFactory factory)
	{
		if (!factories.containsKey(type))
			factories.put(type, factory);
	}

	private List<Listener> getRouters(IRunsafeEvent subscriber)
	{
		ArrayList<Listener> routers = new ArrayList<Listener>();
		for (Class<? extends IRunsafeEvent> type : factories.keySet())
			if (type.isAssignableFrom(subscriber.getClass()))
				routers.add(factories.get(type).getListener(output, scheduler, subscriber));
		return routers;
	}

	private static final Map<Class<? extends IRunsafeEvent>, EventRouterFactory> factories;

	private final List<IRunsafeEvent> eventSubscribers;
	private final IScheduler scheduler;
	private final IOutput output;
}
