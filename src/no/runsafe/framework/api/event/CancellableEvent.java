package no.runsafe.framework.api.event;

public interface CancellableEvent
{
	public boolean isCancelled();
	public void cancel();
	public void addCancellationHandle(Runnable callback);
}
