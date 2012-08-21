package no.runsafe.framework.timer;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Worker<TokenType, StateType> implements Runnable
{
	public Worker(IScheduler scheduler)
	{
		this.scheduler = scheduler;
		this.worker = scheduler.createAsyncTimer(this, 100L, 100L);
	}

	public void Push(TokenType key, StateType value)
	{
		state.put(key, value);
		if (queue.contains(key))
			queue.remove(key);
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
		StateType value = state.get(key);
		state.remove(key);
		process(key, value);
	}

	public abstract void process(TokenType key, StateType value);

	@SuppressWarnings("EmptyMethod")
	protected void onWorkerDone()
	{
	}

	public void setInterval(long ticks)
	{
		if (ticks > 0)
		{
			if (this.worker != null)
				worker.stop();
			worker = scheduler.createAsyncTimer(this, 10L, ticks);
		}
	}

	private void pokeWorker()
	{
		if (worker != null && !worker.isRunning())
			worker.start();
	}

	private final IScheduler scheduler;
	private ITimer worker;
	private final ConcurrentHashMap<TokenType, StateType> state = new ConcurrentHashMap<TokenType, StateType>();
	private final Stack<TokenType> queue = new Stack<TokenType>();
}