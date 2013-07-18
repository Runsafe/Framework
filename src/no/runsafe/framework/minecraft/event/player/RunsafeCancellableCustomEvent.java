package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.api.event.CancellableEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public abstract class RunsafeCancellableCustomEvent extends RunsafeCustomEvent implements CancellableEvent
{
	public RunsafeCancellableCustomEvent(RunsafePlayer player, String event)
	{
		super(player, event);
	}

	@Override
	@Deprecated
	public boolean getCancelled()
	{
		return cancelled;
	}

	@Override
	@Deprecated
	public void setCancelled(boolean cancel)
	{
		if (cancel)
			this.cancel();
		else
			throw new InvalidParameterException("You cannot un-cancel an event");
	}

	public boolean isCancelled()
	{
		return cancelled;
	}

	public void cancel()
	{
		this.cancelled = true;
		for (Runnable callback : onCancelled)
			callback.run();
	}

	public void addCancellationHandle(Runnable callback)
	{
		onCancelled.add(callback);
	}

	private final List<Runnable> onCancelled = new ArrayList<Runnable>();
	private boolean cancelled = false;
}
