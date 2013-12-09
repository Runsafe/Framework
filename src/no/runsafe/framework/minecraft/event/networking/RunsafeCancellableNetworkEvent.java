package no.runsafe.framework.minecraft.event.networking;

import no.runsafe.framework.api.event.CancellableEvent;

import java.util.ArrayList;
import java.util.Collection;

public abstract class RunsafeCancellableNetworkEvent extends RunsafeNetworkEvent implements CancellableEvent
{
	protected RunsafeCancellableNetworkEvent()
	{

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
		if (onCancelled != null)
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
