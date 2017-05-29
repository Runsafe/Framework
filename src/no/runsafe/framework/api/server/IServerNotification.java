package no.runsafe.framework.api.server;

public interface IServerNotification
{
	int broadcastMessage(String message, String permission);

	int broadcastMessage(String message);
}
