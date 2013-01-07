package no.runsafe.framework.server.event.player;

import no.runsafe.framework.IKernel;
import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.event.player.IPlayerLoginEvent;
import no.runsafe.framework.event.player.IPlayerQuitEvent;
import no.runsafe.framework.server.event.IFakeAbleEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.net.InetAddress;

public class RunsafePlayerLoginEvent extends RunsafePlayerEvent implements IFakeAbleEvent
{
	public RunsafePlayerLoginEvent(PlayerLoginEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public void allow()
	{
		event.allow();
	}

	public void serverFull(String message)
	{
		event.disallow(PlayerLoginEvent.Result.KICK_FULL, message);
	}

	public void playerBanned(String message)
	{
		event.disallow(PlayerLoginEvent.Result.KICK_BANNED, message);
	}

	public void playerNotWhitelisted(String message)
	{
		event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, message);
	}

	public void disallow(String message)
	{
		event.disallow(PlayerLoginEvent.Result.KICK_OTHER, message);
	}

	public InetAddress getAddress()
	{
		return event.getAddress();
	}

	public String getHostname()
	{
		return event.getHostname();
	}

	public boolean getHasBeenKicked()
	{
		return event.getResult() != PlayerLoginEvent.Result.ALLOWED;
	}

	public String getKickMessage()
	{
		return event.getKickMessage();
	}

	public void setKickMessage(String message)
	{
		event.setKickMessage(message);
	}

	public void Fire()
	{
		isFake = true;
		for (IKernel plugin : RunsafePlugin.Instances.values())
			for (IPlayerLoginEvent listener : plugin.getComponents(IPlayerLoginEvent.class))
				listener.OnPlayerLogin(this);
	}

	@Override
	public boolean isFake()
	{
		return isFake;
	}

	private final PlayerLoginEvent event;
	private boolean isFake = false;
}
