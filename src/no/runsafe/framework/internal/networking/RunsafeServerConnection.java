package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.DedicatedServer;
import net.minecraft.server.v1_6_R3.MinecraftServer;
import net.minecraft.server.v1_6_R3.ServerConnection;
import no.runsafe.framework.api.log.IConsole;

import java.net.InetAddress;

public class RunsafeServerConnection extends ServerConnection
{
	public RunsafeServerConnection(MinecraftServer server, InetAddress address, int port, IConsole output)
	{
		super(server);

		listener = new RunsafeNetworkListener(server, output, address, port); // Create a new listener.
		new Thread(listener).start(); // Create a thread for our listener and start it.
	}

	public void stop()
	{
		listener.stopRunning(); // Force the listener to stop.
	}

	@Override
	public void a()
	{
		super.a();
		stop(); // Hammer-time.
	}

	@Override
	public void b()
	{
		listener.processConnections(); // Check over our connections.
		super.b();
	}

	// Why is this .. ?
	public DedicatedServer getDedicatedServer()
	{
		return (DedicatedServer) super.d();
	}

	@Override
	public MinecraftServer d()
	{
		return getDedicatedServer();
	}

	private final RunsafeNetworkListener listener;
}
