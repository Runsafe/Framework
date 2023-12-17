package no.runsafe.framework.api.log;

public interface IProtocol
{
	void logException(Exception exception);

	void logInformation(String message, Object... params);

	void logWarning(String message, Object... params);

	void logError(String message, Object... params);
}
