package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.Connection;
import net.minecraft.server.v1_6_R3.MinecraftServer;
import net.minecraft.server.v1_6_R3.PendingConnection;
import no.runsafe.framework.api.IOutput;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RunsafeNetworkListener implements Runnable
{
	public RunsafeNetworkListener(MinecraftServer server, IOutput output, InetAddress address, int port)
	{
		this.output = output;
		this.server = server;

		try
		{
			serverSocket = new ServerSocket(port, 0, address); // Open our socket.
			serverSocket.setPerformancePreferences(0, 2, 1); // Minecraft hard-coded settings.
		}
		catch (IOException exception)
		{
			stop();
			output.logException(exception);
			output.logFatal("Exception prevented network listener from starting; Shutting down.");
		}
	}

	@Override
	public void run()
	{
		output.logInformation("RunsafeNetworkListener running.");
		while (running)
		{
			try
			{
				Socket socket = serverSocket.accept();
				addConnection(new RunsafePendingConnection(server, socket, getNewConnectionName(), output));
			}
			catch (IOException exception)
			{
				output.logException(exception);
			}
		}

		try
		{
			serverSocket.close();
		}
		catch (IOException exception)
		{
			output.logException(exception);
		}

		output.logWarning("Listening thread closed.");
	}

	private String getNewConnectionName()
	{
		connectionCount++;
		return "Connection #" + connectionCount;
	}

	@SuppressWarnings({"LocalVariableOfConcreteClass", "CastToConcreteClass"})
	public void processConnections()
	{
		synchronized (connections)
		{
			// NOTE: Replace this with a better form of iteration.
			// Loop over every pending connection we have in the thread.
			for (int i = 0; i < connections.size(); ++i)
			{
				// Get the connection as a pending connection.
				RunsafePendingConnection connection = (RunsafePendingConnection) connections.get(i);

				try
				{
					connection.d(); // Check pending progress, will disconnect after 600 ticks.
				}
				catch (Exception exception)
				{
					// We had an issue, discard the connection.
					connection.disconnect("Something exploded, sorry about that! (Internal Server Error)");
					output.logError("Failed to handle packet for %s.", connection.getName());
					output.logException(exception);
				}

				// NOTE: This seems sketchy.
				if (connection.b) // If this is true, the connection has been discarded.
					connections.remove(i--); // Remove the connection.

				connection.networkManager.a(); // Unknown.
			}
		}
	}

	private void addConnection(PendingConnection connection)
	{
		if (connection == null)
		{
			throw new IllegalArgumentException("NULL PendingConnection provided.");
		}
		else
		{
			synchronized (connections)
			{
				connections.add(connection);
			}
		}
	}

	private void stop()
	{
		output.logWarning("Stopping listening thread..");
		running = false;
	}

	// The reason we have a public method to call a private method rather than make
	// stop() public is to prevent over-riding issues stopping the thread from exiting itself.
	public void stopRunning()
	{
		stop();
	}

	private volatile boolean running = true;
	private final IOutput output;
	private final MinecraftServer server;
	private ServerSocket serverSocket;
	private int connectionCount;
	private final List<Connection> connections = Collections.synchronizedList(new ArrayList<Connection>(0));
}
