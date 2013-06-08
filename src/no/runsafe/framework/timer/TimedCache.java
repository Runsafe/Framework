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
		RefreshTimer();
		return cache.putIfAbsent(key, value);
	}

	private void RefreshTimer()
	{
		if (task > 0)
			scheduler.cancelTask(task);

		task = scheduler.startAsyncTask(
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
	}

	private final ConcurrentHashMap<Key, Value> cache = new ConcurrentHashMap<Key, Value>();
	private final IScheduler scheduler;
	private int task;
}
