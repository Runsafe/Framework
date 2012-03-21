package me.Kruithne.RMPF;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Server;


public class RMPFOutput {

	private Server serverOutput;
	private Logger consoleLog;
	
	public RMPFOutput(Server server)
	{
		this.serverOutput = server;
	}
	
	public RMPFOutput(Logger logger)
	{
		this.consoleLog = logger;
	}
	
	public RMPFOutput(Server server, Logger logger)
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
	public void outputToConsole(String message)
	{
		if (this.hasConsole())
		{
			this.consoleLog.log(Level.INFO, message);
		}
	}
	
	// Sends the supplied string with the supplied logging level to the console/log the outputter has
	public void outputToConsole(String message, Level level)
	{
		if (this.hasConsole())
		{
			this.consoleLog.log(level, message);
		}
	}
	
	// Broadcasts the supplied string to all players on the server the outputter has
	public void outputToServer(String message)
	{
		if (this.hasServer())
		{
			this.serverOutput.broadcastMessage(message);
		}
	}
	
}
