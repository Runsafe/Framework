package no.runsafe.framework.event.server;

import org.bukkit.event.Cancellable;

public interface CancellableEvent
{
	public boolean getCancelled();
	public void setCancelled(boolean cancel);
}
