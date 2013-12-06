package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.DedicatedServerConnectionThread;
import net.minecraft.server.v1_6_R3.ServerConnection;
import no.runsafe.framework.api.IOutput;

import java.io.IOException;
import java.net.InetAddress;

public class RunsafeServerConnectionThread extends DedicatedServerConnectionThread
{
	public RunsafeServerConnectionThread(ServerConnection connection, InetAddress address, int i, IOutput output) throws IOException
	{
		super(connection, address, i);
		output.logInformation("Runsafe connection thread initialized.");
	}
}
