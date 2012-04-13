package no.runsafe.framework.server.event;

public interface CancellableEvent
{
	public boolean getCancelled();
	public void setCancelled(boolean cancel);
}
