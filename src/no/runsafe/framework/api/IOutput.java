package no.runsafe.framework.api;

public interface IOutput extends IConsole
{
	// Broadcasts the supplied String to all players on the event the output handler has
	void outputToServer(String message);

	@Deprecated
	void broadcastColoured(String message);

	void broadcastColoured(String format, Object... params);
}