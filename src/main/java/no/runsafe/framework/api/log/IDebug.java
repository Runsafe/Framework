package no.runsafe.framework.api.log;

import java.util.logging.Level;

public interface IDebug
{
	// Sends the supplied String to the console/log the output handler has if the debug level is high enough
	void outputDebugToConsole(String message, Level messageLevel, Object... params);

	// Gets the current debug output level
	Level getDebugLevel();

	// Sets the debug output level
	void setDebugLevel(Level level);

	void debugSevere(String message, Object... params);

	void debugWarning(String message, Object... params);

	void debugInfo(String message, Object... params);

	void debugConfig(String message, Object... params);

	void debugFine(String message, Object... params);

	void debugFiner(String message, Object... params);

	void debugFinest(String message, Object... params);

	void debugDump(Object object, Level messageLevel);
}
