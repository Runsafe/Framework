package no.runsafe.framework.timer;

public interface ITimer
{
	void Cancel();

	void ResetSeconds(int seconds);

	void ResetTicks(Long ticks);

	void stop();

	void start();

	boolean isRunning();
}
