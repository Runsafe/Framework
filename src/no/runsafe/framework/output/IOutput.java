package no.runsafe.framework.output;

public interface IOutput extends IDebug
{
	// Broadcasts the supplied string to all players on the event the output handler has
	public void outputToServer(String message);

	void broadcastColoured(String message);

	void broadcastColoured(String format, Object... params);
}