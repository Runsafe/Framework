package no.runsafe.framework.output;

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

	// Check if the output handler has a event available to broadcast to
	private boolean hasServer()
	{
		return this.serverOutput != null;
	}
	
	// Check if the output handler has a console/log available to broadcast to
	private boolean hasConsole()
	{
		return this.serverOutput != null;
	}
	
	// Sends the supplied string to the console/log the output handler has
	@Override
	public void outputToConsole(String message)
	{
		outputToConsole(message, Level.INFO);
	}

	@Override
	public void outputColoredToConsole(String message, Level level)
	{
		outputToConsole(ConsoleColors.FromMinecraft(message), level);
	}

	// Sends the supplied string with the supplied logging level to the console/log the output handler has
	@Override
	public void outputToConsole(String message, Level level)
	{
		if (this.hasConsole())
		{
			this.consoleLog.log(level, message);
		}
	}

	// Sends the supplied string to the console/log the output handler has if the debug level is high enough
	@Override
	public void outputDebugToConsole(String message, Level messageLevel)
	{
		if(debugLevel != null && messageLevel.intValue() >= debugLevel.intValue())	
			outputToConsole(message, Level.INFO);
	}
	
	// Broadcasts the supplied string to all players on the event the output handler has
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
