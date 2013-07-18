package no.runsafe.framework.minecraft.event.inventory;

import no.runsafe.framework.api.event.CancellableEvent;
import org.bukkit.event.Cancellable;
import org.bukkit.event.inventory.InventoryEvent;

import java.util.ArrayList;
import java.util.List;

public class RunsafeCancellableInventoryEvent extends RunsafeInventoryEvent implements CancellableEvent
{
	public RunsafeCancellableInventoryEvent(InventoryEvent toWrap)
	{
		super(toWrap);
		event = (Cancellable) toWrap;
	}

	@Override
	@Deprecated
	public boolean getCancelled()
	{
		return event.isCancelled();
	}

	@Override
	@Deprecated
	public void setCancelled(boolean cancel)
	{
		if (cancel)
			this.cancel();
		else
			throw new IllegalArgumentException("You cannot un-cancel an event!");
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
		for (Runnable callback : cancellationCallbacks)
			callback.run();
	}

	@Override
	public void addCancellationHandle(Runnable callback)
	{
		cancellationCallbacks.add(callback);
	}

	private final List<Runnable> cancellationCallbacks = new ArrayList<Runnable>();
	private final Cancellable event;
}