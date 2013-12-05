package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_6_R3.DedicatedServerConnection;
import net.minecraft.server.v1_6_R3.MinecraftServer;
import no.runsafe.framework.api.IConsole;

import java.net.InetAddress;

public class RunsafeServerConnection extends DedicatedServerConnection
{
	public RunsafeServerConnection(MinecraftServer server, InetAddress address, int i, IConsole output)
	{
		super(server, address, i);
		this.output = output;
		this.output.logInformation("RunsafeServerConnection successfully loaded.");
	}

	private final IConsole output;
}
