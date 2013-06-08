package no.runsafe.framework.timer;

import java.util.concurrent.ConcurrentHashMap;

public class TimedCache<Key, Value>
{
	public TimedCache(IScheduler scheduler)
	{
		this.scheduler = scheduler;
	}

	public void Invalidate(Key key)
	{
		cache.remove(key);
	}

	public Value Cache(Key key)
	{
		return cache.containsKey(key) ? cache.get(key) : null;
	}

	public Value Cache(Key key, Value value)
	{
		RefreshTimer(key);
		return cache.putIfAbsent(key, value);
	}

	private void RefreshTimer(Key key)
	{
		if (timers.containsKey(key))
			scheduler.cancelTask(timers.get(key));

		int task = scheduler.startAsyncTask(
			new Runnable()
			{
				@Override
				public void run()
				{
					cache.clear();
				}
			},
			300
		);
		int activeTask = timers.putIfAbsent(key, task);
		if (activeTask != task)
			scheduler.cancelTask(task);
	}

	private final ConcurrentHashMap<Key, Value> cache = new ConcurrentHashMap<Key, Value>();
	private final ConcurrentHashMap<Key, Integer> timers = new ConcurrentHashMap<Key, Integer>();
	private final IScheduler scheduler;
}
