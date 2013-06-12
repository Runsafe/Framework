package no.runsafe.framework.internal;

import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.text.ChatColour;

import java.util.logging.Logger;


public final class Broadcaster extends Output implements IOutput
{
	public Broadcaster(RunsafeServer server, Logger logger)
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
