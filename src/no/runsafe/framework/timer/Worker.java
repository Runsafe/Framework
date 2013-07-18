package no.runsafe.framework.timer;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.ITimer;
import no.runsafe.framework.internal.Minecraft;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Worker<TokenType, StateType> implements Runnable
{
	public Worker(IScheduler scheduler)
	{
		this(scheduler, Minecraft.TICKS_PER_SECOND);
	}

	public Worker(IScheduler scheduler, long ticks)
	{
		this.scheduler = scheduler;
		worker = scheduler.createAsyncTimer(this, ticks, ticks);
	}

	public void Push(TokenType key, StateType value)
	{
		if (value != null)
			state.put(key, value);
		else if (state.containsKey(key))
			state.remove(key);
		if (!queue.contains(key))
			queue.push(key);
		pokeWorker();
	}

	@Override
	public void run()
	{
		if (queue.empty())
		{
			worker.stop();
			onWorkerDone();
			return;
		}

		TokenType key = queue.pop();
		StateType value = state.containsKey(key) ? state.get(key) : null;
		state.remove(key);
		process(key, value);
	}

	public abstract void process(TokenType key, StateType value);

	@SuppressWarnings({"EmptyMethod", "NoopMethodInAbstractClass"})
	protected void onWorkerDone()
	{
	}

	public void setInterval(long ticks)
	{
		if (ticks > 0)
		{
			if (worker != null)
				worker.stop();
			worker = scheduler.createAsyncTimer(this, Minecraft.TICKS_PER_SECOND, ticks);
		}
	}

	void pokeWorker()
	{
		if (worker != null && worker.isDone())
			worker.start();
	}

	private final IScheduler scheduler;
	private ITimer worker;
	private final ConcurrentHashMap<TokenType, StateType> state = new ConcurrentHashMap<TokenType, StateType>();
	private final Stack<TokenType> queue = new Stack<TokenType>();
}