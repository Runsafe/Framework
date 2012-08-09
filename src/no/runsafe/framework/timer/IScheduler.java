package no.runsafe.framework.timer;

public interface IScheduler
{
	int startSyncTask(Runnable func, Long ticks);
	int startSyncTask(Runnable func, int seconds);
	int startAsyncTask(Runnable func, Long ticks);
	int startAsyncTask(Runnable func, int seconds);
	int startSyncRepeatingTask(Runnable func, long delay, long period);
	int startSyncRepeatingTask(Runnable func, int delay, int period);
	void cancelTask(int eventId);
	ITimer createSyncTimer(Runnable func, Long delay, Long period);
	ITimer createSyncTimer(Runnable func, Long delay);
	ITimer createSyncTimer(Runnable func, int delay, int period);
	ITimer createSyncTimer(Runnable func, int delay);
}