package no.runsafe.framework.api;

public interface IOutput extends IConsole
{
	// Broadcasts the supplied String to all players on the event the output handler has
	@Deprecated
	void outputToServer(String message);

	void broadcastColoured(String format, Object... params);
}