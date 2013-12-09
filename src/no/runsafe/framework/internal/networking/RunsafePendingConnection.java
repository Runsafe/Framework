package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.MinecraftServer;
import net.minecraft.server.v1_6_R3.PendingConnection;

import java.io.IOException;
import java.net.Socket;

public class RunsafePendingConnection extends PendingConnection
{
	public RunsafePendingConnection(MinecraftServer server, Socket socket, String s) throws IOException
	{
		super(server, socket, s);
	}

	// We override this function to remove "lost connection" spam.
	@Override
	public void a(String s, Object[] aobject)
	{
		b = true;
	}
}
