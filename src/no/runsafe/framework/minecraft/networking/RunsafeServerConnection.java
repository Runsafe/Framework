package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_6_R3.DedicatedServerConnection;
import net.minecraft.server.v1_6_R3.MinecraftServer;
import no.runsafe.framework.api.IDebug;

import java.net.InetAddress;

public class RunsafeServerConnection extends DedicatedServerConnection
{
	public RunsafeServerConnection(MinecraftServer server, InetAddress address, int i, IDebug output)
	{
		super(server, address, i);
		this.output = output;

		this.output.logInformation("RunsafeServerConnection successfully interjected.");
	}

	private final IDebug output;
}
