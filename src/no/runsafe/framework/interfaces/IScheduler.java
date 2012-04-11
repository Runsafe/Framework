package no.runsafe.framework.interfaces;

public interface IScheduler {

	public abstract int setTimedEvent(Runnable func, Long ticks);

	public abstract int setTimedEvent(Runnable func, int seconds);

	void cancelTimedEvent(int eventId);
}