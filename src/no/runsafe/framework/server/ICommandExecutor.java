package no.runsafe.framework.server;

public interface ICommandExecutor
{
	String getName();

	void sendMessage(String message);

	void sendColouredMessage(String message);

	void sendColouredMessage(String format, Object... params);

	boolean hasPermission(String permission);
}
