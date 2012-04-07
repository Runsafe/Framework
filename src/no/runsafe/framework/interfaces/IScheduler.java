package no.runsafe.framework.interfaces;

public interface IScheduler {

	public abstract void setTimedEvent(Runnable func, Long ticks);

	public abstract void setTimedEvent(Runnable func, int seconds);

}