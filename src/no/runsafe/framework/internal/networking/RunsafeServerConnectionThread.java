package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.DedicatedServerConnectionThread;
import net.minecraft.server.v1_6_R3.ServerConnection;

import java.io.IOException;
import java.net.InetAddress;

public class RunsafeServerConnectionThread extends DedicatedServerConnectionThread
{
	public RunsafeServerConnectionThread(ServerConnection connection, InetAddress address, int i) throws IOException
	{
		super(connection, address, i);
	}
}
