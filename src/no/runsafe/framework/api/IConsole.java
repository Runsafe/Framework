package no.runsafe.framework.api;

import java.util.logging.Level;

public interface IConsole
{
	// Sends the supplied String to the console/log the output handler has
	@Deprecated
	void outputToConsole(String message);

	// Sends the supplied String with the supplied logging level to the console/log the output handler has
	void outputToConsole(String message, Level level);

	@Deprecated
	void writeColoured(String message);

	@Deprecated
	void writeColoured(String message, Object... params);

	void writeColoured(String message, Level level, Object... params);

	void logException(Exception exception);

	void logWarning(String message, Object... params);

	void logError(String message, Object... params);

	/**
	 * This will log a fatal error and make the server die in a great big fireball.
	 *
	 * @param message The message to print before exiting the process.
	 * @param params  Values to be passed into the message using String.format
	 */
	void logFatal(String message, Object... params);

	void logInformation(String message, Object... params);

	String getLogFormat();
	String getDebugFormat();
}
