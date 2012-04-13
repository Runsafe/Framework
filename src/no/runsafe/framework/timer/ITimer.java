package no.runsafe.framework.timer;

public interface ITimer
{
	public void Cancel();
	public void ResetSeconds(int seconds);
	public void ResetTicks(Long ticks);

	void stop();

	void start();
}
