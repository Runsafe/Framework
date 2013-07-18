package no.runsafe.framework.api.event;

public interface CancellableEvent
{
	@Deprecated
	public boolean getCancelled();

	@Deprecated
	public void setCancelled(boolean cancel);

	public boolean isCancelled();
	public void cancel();
	public void addCancellationHandle(Runnable callback);
}
