package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.Player;
import no.runsafe.framework.minecraft.event.RunsafeEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.net.InetAddress;
import java.util.UUID;

public class RunsafePlayerPreLoginEvent extends RunsafeEvent
{
	public RunsafePlayerPreLoginEvent(AsyncPlayerPreLoginEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public IPlayer getPlayer()
	{
		return Player.Get().getExact(event.getUniqueId());
	}

	public String getName()
	{
		return event.getName();
	}

	public UUID getUniqueId()
	{
		return event.getUniqueId();
	}

	public void allow()
	{
		event.allow();
	}

	public void serverFull(String message)
	{
		event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL, message);
	}

	public void playerBanned(String message)
	{
		event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, message);
	}

	public void playerNotWhitelisted(String message)
	{
		event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_WHITELIST, message);
	}

	public void disallow(String message)
	{
		event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, message);
	}

	public InetAddress getAddress()
	{
		return event.getAddress();
	}

	public boolean getHasBeenKicked()
	{
		return event.getLoginResult() != AsyncPlayerPreLoginEvent.Result.ALLOWED;
	}

	public String getKickMessage()
	{
		return event.getKickMessage();
	}

	public void setKickMessage(String message)
	{
		event.setKickMessage(message);
	}

	private final AsyncPlayerPreLoginEvent event;
}
