package no.runsafe.framework.api;

public interface IOutput extends IDebug
{
	// Broadcasts the supplied String to all players on the event the output handler has
	public void outputToServer(String message);

	void broadcastColoured(String message);

	void broadcastColoured(String format, Object... params);
}