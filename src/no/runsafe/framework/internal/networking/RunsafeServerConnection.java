package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.MinecraftServer;
import net.minecraft.server.v1_6_R3.ServerConnection;
import no.runsafe.framework.api.IOutput;

import java.io.IOException;
import java.net.InetAddress;

public class RunsafeServerConnection extends ServerConnection
{
	public RunsafeServerConnection(MinecraftServer server, InetAddress address, int i, IOutput output) throws IOException
	{
		super(server);
		thread = new RunsafeServerConnectionThread(this, address, i, output);
		thread.start();
	}

	private final RunsafeServerConnectionThread thread;
}
