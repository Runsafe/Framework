package no.runsafe.framework.event;

import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.listener.Factories;
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
	static
	{
		factories = new HashMap<Class<? extends IRunsafeEvent>, EventRouterFactory>();
		Factories.Register();
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

	public static void Register(Class<? extends EventRouterFactory> factoryClass)
	{
		try
		{
			EventRouterFactory factory = factoryClass.getConstructor().newInstance();
			if (!factories.containsKey(factory.getInterface()))
				factories.put(factory.getInterface(), factory);
		}
		catch (Exception e)
		{
		}
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
