package no.runsafe.framework.api.command;

import java.util.UUID;

public interface ICommandExecutor
{
	String getName();
	UUID getUniqueId();
	void sendMessage(String message);
	void sendColouredMessage(String format, Object... params);
	boolean hasPermission(String permission);
	boolean performCommand(String command);
	@Override boolean equals(Object o);
	@Override int hashCode();
}
