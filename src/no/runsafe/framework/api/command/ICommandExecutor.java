package no.runsafe.framework.api.command;

public interface ICommandExecutor
{
	String getName();
	void sendMessage(String message);
	void sendColouredMessage(String format, Object... params);
	boolean hasPermission(String permission);
}
