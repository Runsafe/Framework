package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.api.event.CancellableEvent;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;

import java.util.ArrayList;
import java.util.Collection;

public abstract class RunsafeCancellablePlayerEvent extends RunsafePlayerEvent implements CancellableEvent
{
	public RunsafeCancellablePlayerEvent(PlayerEvent toWrap)
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
		for (Runnable callback : cancellationCallbacks)
			callback.run();
	}

	@Override
	public void addCancellationHandle(Runnable callback)
	{
		cancellationCallbacks.add(callback);
	}

	private final Collection<Runnable> cancellationCallbacks = new ArrayList<Runnable>();
	private final Cancellable event;
}
