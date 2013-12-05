package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_6_R3.DedicatedServerConnection;
import net.minecraft.server.v1_6_R3.MinecraftServer;

import java.net.InetAddress;

public class RunsafeServerConnection extends DedicatedServerConnection
{
	public RunsafeServerConnection(MinecraftServer server, InetAddress address, int i)
	{
		super(server, address, i);
	}
}
