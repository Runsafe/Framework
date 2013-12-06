package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.DedicatedServer;
import net.minecraft.server.v1_6_R3.DedicatedServerConnectionThread;
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

	public void a()
	{
		super.a();
		thread.b();
		thread.interrupt();
	}

	public void b()
	{
		thread.a();
		super.b();
	}

	public DedicatedServer c()
	{
		return (DedicatedServer) super.d();
	}

	public void a(InetAddress address)
	{
		thread.a(address);
	}

	public MinecraftServer d()
	{
		return c();
	}

	private final DedicatedServerConnectionThread thread;
}
