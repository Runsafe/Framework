package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.*;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.event.networking.RunsafeLoginVerifiedEvent;
import org.apache.commons.lang.StringUtils;
import org.bukkit.craftbukkit.v1_6_R3.event.CraftEventFactory;
import org.bukkit.event.server.ServerListPingEvent;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("ParameterNameDiffersFromOverriddenParameter")
public class RunsafePendingConnection extends PendingConnection
{
	public RunsafePendingConnection(MinecraftServer server, Socket socket, String s, IOutput output) throws IOException
	{
		super(server, socket, s);
		this.server = server;
		this.output = output;
	}

	@Override
	public void d()
	{
		if (verified)
			e();

		loginTicks++;
		if (loginTicks == TIMEOUT)
			disconnect("You took too long to log in, are the Mojang servers down?");
		else
			networkManager.b();
	}

	@Override
	public void disconnect(String message)
	{
		// ToDo: Log disconnect.
		networkManager.queue(new Packet255KickDisconnect(message));
	}

	@Override
	public void a(Packet2Handshake packet)
	{
		if (playerName != null)
		{
			disconnect("Duplicate handshake, go away!");
			return;
		}

		hostname = String.format("%s:%s", packet.c, packet.d);
		playerName = packet.f(); // Grab the players name.

		if (!playerName.equals(StripColor.a(playerName)))
		{
			disconnect("What kind of a name is that? Go away.");
			return;
		}

		PublicKey key = server.H().getPublic();
		if (packet.d() == CURRENT_VERSION)
		{
			loginKey = server.getOnlineMode() ? Long.toString(random.nextLong(), LOGIN_KEY_RADIX) : "-";
			keyByte = new byte[4];
			random.nextBytes(keyByte);
			networkManager.queue(new Packet253KeyRequest(loginKey, key, keyByte));
		}
		else
		{
			disconnect(String.format("Please use a profile set to %s to play on this server!", CURRENT_VERSION_STRING));
		}
	}

	@Override
	public void a(Packet252KeyResponse packet)
	{
		PrivateKey key = server.H().getPrivate();
		secretKey = packet.a(key);

		if (!Arrays.equals(keyByte, packet.b(key)))
			disconnect("Invalid client reply.");

		networkManager.queue(new Packet252KeyResponse());
	}

	@Override
	public void a(Packet205ClientCommand packet)
	{
		if (packet.a == 0)
		{
			if (loggingIn)
			{
				disconnect("Duplicate login");
				return;
			}

			loggingIn = true;
			if (server.getOnlineMode())
				new Thread(new RunsafeLoginVerifier(this)).start();
			else
				setVerified(true);
		}
	}

	@Override
	public void e()
	{
		RunsafeLoginVerifiedEvent event = new RunsafeLoginVerifiedEvent(playerName);
		event.Fire();

		playerName = event.getPlayerName();

		PlayerList playerList = server.getPlayerList();
		EntityPlayer player = playerList.attemptLogin(this, playerName, hostname);

		if (player != null)
		{
			EntityPlayer processedPlayer = playerList.processLogin(player);
			if (processedPlayer != null)
				playerList.a(networkManager, processedPlayer);

			b = true;
		}
	}

	@Override
	public void a(Packet254GetInfo packet)
	{
		if(networkManager.getSocket() == null)
			return;

		try
		{
			PlayerList playerlist = server.getPlayerList();
			String response;
			ServerListPingEvent pingEvent = CraftEventFactory.callServerListPingEvent(server.server, getSocket().getInetAddress(), server.getMotd(), playerlist.getPlayerCount(), playerlist.getMaxPlayers());

			if(packet.d())
			{
				response = new StringBuilder(0).append(pingEvent.getMotd()).append('\247').append(playerlist.getPlayerCount()).append('\247').append(pingEvent.getMaxPlayers()).toString();
			}
			else
			{
				Object[] list = {
						1, CURRENT_VERSION, server.getVersion(), pingEvent.getMotd(), playerlist.getPlayerCount(), pingEvent.getMaxPlayers()
				};
				StringBuilder builder = new StringBuilder(0);

				for (Object node : list)
				{
					builder.append(builder.length() == 0 ? '\247' : '\0');
					builder.append(StringUtils.replace(node.toString(), "\0", ""));
				}
				response = builder.toString();
			}

			networkManager.queue(new Packet255KickDisconnect(response));
			networkManager.d();

			b = true;
		}
		catch (Exception exception)
		{
			output.logException(exception);
		}
	}

	@Override
	public void a(String s, Object[] aobject)
	{
		b = true;
	}

	public String getLoginKey()
	{
		return loginKey;
	}

	public MinecraftServer getServer()
	{
		return server;
	}

	public SecretKey getSecretKey()
	{
		return secretKey;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public boolean setVerified(boolean flag)
	{
		verified = flag;
		return verified;
	}

	// Checked
	protected final IOutput output;
	protected byte[] keyByte; // d
	protected static final int TIMEOUT = 600;
	protected static final int CURRENT_VERSION = 78;
	protected static final int LOGIN_KEY_RADIX = 16;
	protected static final String CURRENT_VERSION_STRING = "1.6.4";

	private int loginTicks;
	private String playerName; // g
	private boolean loggingIn;
	private SecretKey secretKey;
	private String loginKey = "";
	private volatile boolean verified;
	private final MinecraftServer server;
	private static final Random random = new Random();
}
