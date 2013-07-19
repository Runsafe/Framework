package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.api.event.CancellableEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.ArrayList;
import java.util.Collection;

public abstract class RunsafeCancellableCustomEvent extends RunsafeCustomEvent implements CancellableEvent
{
	protected RunsafeCancellableCustomEvent(RunsafePlayer player, String event)
	{
		super(player, event);
	}

	@Override
	public boolean isCancelled()
	{
		return cancelled;
	}

	@Override
	public void cancel()
	{
		cancelled = true;
		for (Runnable callback : onCancelled)
			callback.run();
	}

	@Override
	public void addCancellationHandle(Runnable callback)
	{
		if (onCancelled == null)
			onCancelled = new ArrayList<Runnable>(1);
		onCancelled.add(callback);
	}

	private Collection<Runnable> onCancelled;
	private boolean cancelled;
}
