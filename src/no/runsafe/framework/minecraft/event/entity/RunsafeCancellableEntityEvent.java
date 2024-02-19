package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.api.event.CancellableEvent;
import org.bukkit.event.Cancellable;
import org.bukkit.event.entity.EntityEvent;

import java.util.ArrayList;
import java.util.Collection;

public class RunsafeCancellableEntityEvent extends RunsafeEntityEvent implements CancellableEvent
{
	public RunsafeCancellableEntityEvent(EntityEvent toWrap)
	{
		super(toWrap);
		event = (Cancellable) toWrap;
	}

	@Override
	public boolean isCancelled()
	{
		return event.isCancelled();
	}

	@Override
	public void cancel()
	{
		event.setCancelled(true);
		if (cancellationCallbacks != null)
			for (Runnable callback : cancellationCallbacks)
				callback.run();
	}

	@Override
	public void addCancellationHandle(Runnable callback)
	{
		if (cancellationCallbacks == null)
			cancellationCallbacks = new ArrayList<>(1);
		cancellationCallbacks.add(callback);
	}

	private Collection<Runnable> cancellationCallbacks;
	private final Cancellable event;
}
