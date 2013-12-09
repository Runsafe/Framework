package no.runsafe.framework.internal.event;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.internal.event.listener.Factories;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.picocontainer.Startable;

import java.util.*;

public final class EventEngine implements Startable
{
	static
	{
		factories = new HashMap<Class<? extends IRunsafeEvent>, EventRouterFactory>(0);
	}

	public EventEngine(IConsole output, IScheduler scheduler, PluginManager manager, RunsafePlugin plugin, IDebug debug)
	{
		this(output, scheduler, manager, plugin, debug, new IRunsafeEvent[0]);
	}

	public EventEngine(
		IConsole output, IScheduler scheduler, PluginManager manager, RunsafePlugin plugin, IDebug debug, IRunsafeEvent... events)
	{
		eventSubscribers = events;
		this.scheduler = scheduler;
		this.output = output;
		this.debug = debug;
		pluginManager = manager;
		this.plugin = plugin;
	}

	@Override
	public void start()
	{
		if (eventSubscribers != null)
		{
			Factories.Register();
			for (Listener listener : getListeners())
			{
				pluginManager.registerEvents(listener, plugin);
				debug.debugFiner("Registered event listener %s", listener.getClass().getName());
			}
		}
	}

	@Override
	public void stop()
	{
	}

	public static void Register(EventRouterFactory factory)
	{
		if (!factories.containsKey(factory.getInterface()))
			factories.put(factory.getInterface(), factory);
	}

	private Iterable<Listener> getListeners()
	{
		List<Listener> listeners = new ArrayList<Listener>(eventSubscribers.length);
		for (IRunsafeEvent sub : eventSubscribers)
			listeners.addAll(getRouters(sub));
		return listeners;
	}

	private Collection<Listener> getRouters(IRunsafeEvent subscriber)
	{
		List<Listener> routers = new ArrayList<Listener>(factories.size());
		for (Map.Entry<Class<? extends IRunsafeEvent>, EventRouterFactory> factory : factories.entrySet())
			if (factory.getKey().isAssignableFrom(subscriber.getClass()))
				routers.add(factory.getValue().getListener(output, scheduler, subscriber));
		return routers;
	}

	private static final Map<Class<? extends IRunsafeEvent>, EventRouterFactory> factories;
	private final IRunsafeEvent[] eventSubscribers;
	private final IScheduler scheduler;
	private final IConsole output;
	private final IDebug debug;
	private final PluginManager pluginManager;
	private final RunsafePlugin plugin;
}
