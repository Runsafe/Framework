package no.runsafe.framework.api;

public interface IScheduler
{
	/**
	 * Don't use this method, use createSyncTimer.
	 *
	 * @param func  Code to be executed
	 * @param ticks Delay before executing in ticks
	 * @return Timer ID
	 */
	int startSyncTask(Runnable func, Long ticks);

	/**
	 * Don't use this method, use createSyncTimer.
	 *
	 * @param func    Code to be executed
	 * @param seconds Delay before executing in seconds
	 * @return Timer ID
	 */
	int startSyncTask(Runnable func, int seconds);

	/**
	 * Don't use this method, use createSyncTimer.
	 *
	 * @param func  Code to be executed in ticks
	 * @param ticks Delay before executing in ticks
	 * @return Timer ID
	 */
	int startAsyncTask(Runnable func, Long ticks);

	/**
	 * Don't use this method, use createSyncTimer.
	 *
	 * @param func    Code to be executed in ticks
	 * @param seconds Delay before executing in ticks
	 * @return Timer ID
	 */
	int startAsyncTask(Runnable func, int seconds);

	/**
	 * Don't use this method, use createSyncTimer.
	 *
	 * @param func   Code to be executed
	 * @param delay  Delay before executing in ticks
	 * @param period Delay between each execution in ticks
	 * @return Timer ID
	 */
	int startSyncRepeatingTask(Runnable func, long delay, long period);

	boolean runNow(Runnable func);

	/**
	 * Don't use this method, use createSyncTimer.
	 *
	 * @param func   Code to be executed
	 * @param delay  Delay before executing in seconds
	 * @param period Delay between each execution in seconds
	 * @return Timer ID
	 */
	int startSyncRepeatingTask(Runnable func, int delay, int period);

	/**
	 * Don't use this method, use createSyncTimer.
	 *
	 * @param func   Code to be executed
	 * @param delay  Delay before executing in ticks
	 * @param period Delay between each execution in ticks
	 * @return Timer ID
	 */
	int startAsyncRepeatingTask(Runnable func, long delay, long period);

	/**
	 * Create a timer that will run on the main thread periodically
	 *
	 * @param func   Code to be executed
	 * @param delay  Delay before first execution in ticks
	 * @param period Delay between each execution in ticks
	 * @return a timer
	 */
	ITimer createSyncTimer(Runnable func, Long delay, Long period);

	/**
	 * Create a timer that will run on the main thread periodically
	 *
	 * @param func  Code to be executed
	 * @param ticks Delay before first execution in ticks
	 * @return a timer
	 */
	ITimer createSyncTimer(Runnable func, Long ticks);

	/**
	 * Create a timer that will run on the main thread periodically
	 *
	 * @param func   Code to be executed
	 * @param delay  Delay before first execution in seconds
	 * @param period Delay between each execution in seconds
	 * @return a timer
	 */
	ITimer createSyncTimer(Runnable func, int delay, int period);

	/**
	 * Create a timer that will run on the main thread periodically
	 *
	 * @param func  Code to be executed
	 * @param seconds Delay before first execution in seconds
	 * @return a timer
	 */
	ITimer createSyncTimer(Runnable func, int seconds);

	/**
	 * Create a timer that will run on a background thread periodically
	 *
	 * @param func   Code to be executed
	 * @param delay  Delay before first execution in ticks
	 * @param period Delay between each execution in ticks
	 * @return a timer
	 */
	ITimer createAsyncTimer(Runnable func, Long delay, Long period);

	/**
	 * Create a timer that will run on a background thread periodically
	 *
	 * @param func  Code to be executed
	 * @param ticks Delay before first execution in ticks
	 * @return a timer
	 */
	ITimer createAsyncTimer(Runnable func, Long ticks);

	/**
	 * Create a timer that will run on a background thread periodically
	 *
	 * @param func   Code to be executed
	 * @param delay  Delay before first execution in seconds
	 * @param period Delay between each execution in seconds
	 * @return a timer
	 */
	ITimer createAsyncTimer(Runnable func, int delay, int period);

	/**
	 * Create a timer that will run on a background thread periodically
	 *
	 * @param func  Code to be executed
	 * @param seconds Delay before first execution in seconds
	 * @return a timer
	 */
	ITimer createAsyncTimer(Runnable func, int seconds);

	/**
	 * Cancels a timer, should not be used directly
	 *
	 * @param eventId The timer ID that should be cancelled
	 */
	void cancelTask(int eventId);
}