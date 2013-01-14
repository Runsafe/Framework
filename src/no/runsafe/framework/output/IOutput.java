package no.runsafe.framework.output;

import java.util.logging.Level;

public interface IOutput {

	// Sends the supplied string to the console with &-codes replaced with ANSI sequences
	public void writeColoured(String message);

	public void writeColoured(String message, Object... params);

	public void writeColoured(String message, Level level, Object... params);

	// Sends the supplied string to the console/log the output handler has
	public void outputToConsole(String message);

	// Sends the supplied string with the supplied logging level to the console/log the output handler has
	public void outputToConsole(String message, Level level);

	// Translates ChatColors to TerminalColors and outputs string to server console
	@Deprecated
	public void outputColoredToConsole(String message, Level level);

	// Sends the supplied string to the console/log the output handler has if the debug level is high enough
	public void outputDebugToConsole(String message, Level messageLevel, Object... params);

	// Broadcasts the supplied string to all players on the event the output handler has
	public void outputToServer(String message);

	// Gets the current debug output level
	public Level getDebugLevel();
	
	// Sets the debug output level
	public void setDebugLevel(Level level);

	void write(String message);

	void severe(String message, Object... params);

	void warning(String message, Object... params);

	void info(String message, Object... params);

	void config(String message, Object... params);

	void fine(String message, Object... params);

	void finer(String message, Object... params);

	void finest(String message, Object... params);

	void broadcastColoured(String message);

	void broadcastColoured(String format, Object... params);

	void dumpData(Object object, Level messageLevel);
}