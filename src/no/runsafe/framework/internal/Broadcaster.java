package no.runsafe.framework.internal;

import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.text.ChatColour;

import java.util.logging.Level;

public final class Broadcaster extends Debug implements IOutput
{
	public Broadcaster(InjectionPlugin plugin, IServer server)
	{
		super(plugin);
		serverOutput = server;
	}

	@Deprecated
	@Override
	public void outputToServer(String message)
	{
		outputToConsole(message, Level.INFO);
		broadcast(message);
	}

	@Override
	public void broadcastColoured(String format, Object... params)
	{
		String message = String.format(format, params);
		writeColoured(message, Level.INFO);
		broadcast(ChatColour.ToMinecraft(message));
	}

	private void broadcast(String message)
	{
		for (IPlayer player : serverOutput.getOnlinePlayers())
			player.sendColouredMessage(message);
	}

	private final IServer serverOutput;
}
