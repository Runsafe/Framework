package no.runsafe.framework.internal;

import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.framework.text.ChatColour;

import java.util.logging.Level;

public final class Broadcaster extends Console implements IOutput
{
	public Broadcaster(InjectionPlugin plugin, RunsafeServer server)
	{
		super(plugin);
		serverOutput = server;
	}

	@Override
	public void outputToServer(String message)
	{
		outputToConsole(message, Level.INFO);
		broadcast(message);
	}

	@Override
	public void broadcastColoured(String format, Object... params)
	{
		broadcastColoured(String.format(format, params));
	}

	@Override
	public void broadcastColoured(String message)
	{
		writeColoured(message);
		broadcast(ChatColour.ToMinecraft(message));
	}

	private void broadcast(String message)
	{
		for (RunsafePlayer player : serverOutput.getOnlinePlayers())
			player.sendMessage(message);
	}

	private final RunsafeServer serverOutput;
}
