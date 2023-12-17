package no.runsafe.framework.api.event;

public interface CancellableEvent
{
	boolean isCancelled();
	void cancel();
	void addCancellationHandle(Runnable callback);
}
