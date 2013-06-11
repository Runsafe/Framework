package no.runsafe.framework.api.event;

public interface CancellableEvent
{
	public boolean getCancelled();
	public void setCancelled(boolean cancel);
}
