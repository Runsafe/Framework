package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_7_R1.MinecraftEncryption;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLEncoder;

public class RunsafeLoginVerifier implements Runnable
{
	public RunsafeLoginVerifier(RunsafePendingConnection connection)
	{
		this.connection = connection;
	}

	@Override
	public void run()
	{
		try
		{
			String s = new BigInteger(MinecraftEncryption.a(connection.getLoginKey(), connection.getServer().H().getPublic(), connection.getSecretKey())).toString(RunsafePendingConnection.LOGIN_KEY_RADIX);
			URL url = new URL("http://session.minecraft.net/game/checkserver.jsp?user=" + URLEncoder.encode(connection.getPlayerName(), "UTF-8") + "&serverId=" + URLEncoder.encode(s, "UTF-8"));
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openConnection(connection.getServer().ap()).getInputStream()));
			String response = bufferedreader.readLine();

			bufferedreader.close();
			if (!response.equals("YES"))
			{
				connection.disconnect("Unable to verify your username with the Mojang servers.");
				return;
			}

			connection.setVerified(true);
		}
		catch (Exception exception)
		{
			connection.disconnect("Unable to verify your username, something blew up.");
		}
	}

	private final RunsafePendingConnection connection;
}
