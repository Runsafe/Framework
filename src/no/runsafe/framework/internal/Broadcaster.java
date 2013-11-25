package no.runsafe.framework.internal;

import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.framework.text.ChatColour;

import java.util.logging.Level;
import java.util.logging.Logger;


public final class Broadcaster extends Output implements IOutput
{
	public Broadcaster(RunsafeServer server)
	{
		serverOutput = server;
	}

	@Override
	public void outputToServer(String message)
	{
		outputToConsole(message, Level.INFO);
		for(RunsafePlayer player : serverOutput.getOnlinePlayers())
			player.sendMessage(message);
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
