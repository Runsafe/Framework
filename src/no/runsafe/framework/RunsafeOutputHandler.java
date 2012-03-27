package no.runsafe.framework;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Server;


public class RunsafeOutputHandler implements IOutput {

	private Server serverOutput;
	private Logger consoleLog;
	private Level debugLevel;
	
	public RunsafeOutputHandler(Server server, Logger logger)
	{
		this.serverOutput = server;
		this.consoleLog = logger;
	}

	// Check if the outputter has a server available to broadcast to
	private boolean hasServer()
	{
		return this.serverOutput != null;
	}
	
	// Check if the outputter has a console/log available to broadcast to
	private boolean hasConsole()
	{
		return this.serverOutput != null;
	}
	
	// Sends the supplied string to the console/log the outputter has
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IOutput#outputToConsole(java.lang.String)
	 */
	@Override
	public void outputToConsole(String message)
	{
		outputToConsole(message, Level.INFO);
	}
	
	// Sends the supplied string with the supplied logging level to the console/log the outputter has
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IOutput#outputToConsole(java.lang.String, java.util.logging.Level)
	 */
	@Override
	public void outputToConsole(String message, Level level)
	{
		if (this.hasConsole())
		{
			this.consoleLog.log(level, message);
		}
	}

	// Sends the supplied string to the console/log the outputter has if the debug level is high enough
	@Override
	public void outputDebugToConsole(String message, Level messageLevel)
	{
		if(debugLevel != null && messageLevel.intValue() >= debugLevel.intValue())	
			outputToConsole(message, Level.INFO);
	}
	
	// Broadcasts the supplied string to all players on the server the outputter has
	/* (non-Javadoc)
	 * @see me.Kruithne.RMPF.IOutput#outputToServer(java.lang.String)
	 */
	@Override
	public void outputToServer(String message)
	{
		if (this.hasServer())
		{
			this.serverOutput.broadcastMessage(message);
		}
	}
	
	// Gets the current debug output level
	@Override
	public Level getDebugLevel()
	{
		return this.debugLevel;
	}
	
	// Sets the debug output level
	@Override
	public void setDebugLevel(Level level)
	{
		this.debugLevel = level;
	}
}
