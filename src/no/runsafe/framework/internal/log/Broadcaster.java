package no.runsafe.framework.internal.log;

import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.text.ChatColour;

import java.io.IOException;
import java.util.logging.Level;

public final class Broadcaster extends LoggingBase implements IOutput
{
	public Broadcaster(InjectionPlugin plugin, IServer server, FileManager handler) throws IOException
	{
		super(plugin, handler, "Broadcaster", "broadcast.log");
		serverOutput = server;
	}

	@Override
	public void broadcastColoured(String format, Object... params)
	{
		String message = String.format(format, params);
		writeLog(Level.INFO, ChatColour.ToConsole(message));
		broadcast(ChatColour.ToMinecraft(message));
	}

	private void broadcast(String message)
	{
		for (IPlayer player : serverOutput.getOnlinePlayers())
			player.sendColouredMessage(message);
	}

	private final IServer serverOutput;
}
