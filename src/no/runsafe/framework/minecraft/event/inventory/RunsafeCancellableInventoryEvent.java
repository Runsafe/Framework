package no.runsafe.framework.minecraft.event.inventory;

import no.runsafe.framework.api.event.CancellableEvent;
import org.bukkit.event.Cancellable;
import org.bukkit.event.inventory.InventoryEvent;

import java.util.ArrayList;
import java.util.Collection;

public class RunsafeCancellableInventoryEvent extends RunsafeInventoryEvent implements CancellableEvent
{
	public RunsafeCancellableInventoryEvent(InventoryEvent toWrap)
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
			cancellationCallbacks = new ArrayList<Runnable>(1);
		cancellationCallbacks.add(callback);
	}

	private Collection<Runnable> cancellationCallbacks;
	private final Cancellable event;
}