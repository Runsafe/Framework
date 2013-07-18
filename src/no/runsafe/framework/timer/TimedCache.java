package no.runsafe.framework.timer;

import no.runsafe.framework.api.IScheduler;

import javax.annotation.Nullable;
import java.util.concurrent.ConcurrentHashMap;

public class TimedCache<Key, Value>
{
	public TimedCache(IScheduler scheduler)
	{
		this.scheduler = scheduler;
	}

	public void Invalidate(Key key)
	{
		if (key != null)
			cache.remove(key);
	}

	public void Purge()
	{
		for (int timer : timers.values())
			scheduler.cancelTask(timer);
		cache.clear();
		timers.clear();
	}

	@Nullable
	public Value Cache(Key key)
	{
		return key != null && cache.containsKey(key) ? cache.get(key) : null;
	}

	public Value Cache(Key key, Value value)
	{
		if (key == null)
			return value;
		RefreshTimer(key);
		Value cached = cache.putIfAbsent(key, value);
		return cached == null ? value : cached;
	}

	private void RefreshTimer(final Key key)
	{
		if (timers.containsKey(key))
			scheduler.cancelTask(timers.get(key));

		int task = scheduler.startAsyncTask(
			new Runnable()
			{
				@Override
				public void run()
				{
					Invalidate(key);
				}
			},
			300
		);
		Integer activeTask = timers.putIfAbsent(key, task);
		if (activeTask != null)
			scheduler.cancelTask(task);
	}

	private final ConcurrentHashMap<Key, Value> cache = new ConcurrentHashMap<Key, Value>();
	private final ConcurrentHashMap<Key, Integer> timers = new ConcurrentHashMap<Key, Integer>();
	private final IScheduler scheduler;
}
