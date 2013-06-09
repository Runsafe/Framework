package no.runsafe.framework.output;

import no.runsafe.framework.server.RunsafeServer;

import java.util.logging.Logger;


public class RunsafeOutputHandler extends RunsafeDebugger implements IOutput
{
	public RunsafeOutputHandler(RunsafeServer server, Logger logger)
	{
		super(logger);
		this.serverOutput = server;
	}

	// Broadcasts the supplied string to all players on the event the output handler has
	@Override
	public void outputToServer(String message)
	{
		this.serverOutput.broadcastMessage(message);
	}

	@Override
	public void broadcastColoured(String format, Object... params)
	{
		broadcastColoured(String.format(format, params));
	}

	@Override
	public void broadcastColoured(String message)
	{
		outputToServer(ChatColour.ToMinecraft(message));
	}

	private final RunsafeServer serverOutput;
}
