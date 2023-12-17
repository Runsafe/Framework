package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.event.IFakeableEvent;
import no.runsafe.framework.api.event.player.IPlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.net.InetAddress;

public class RunsafePlayerLoginEvent extends RunsafePlayerEvent implements IFakeableEvent
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

	@Override
	public boolean Fire()
	{
		isFake = true;
		for (IPlayerLoginEvent listener : RunsafePlugin.getAllPluginComponents(IPlayerLoginEvent.class))
			listener.OnPlayerLogin(this);
		return true;
	}

	@Override
	public boolean isFake()
	{
		return isFake;
	}

	private final PlayerLoginEvent event;
	private boolean isFake;
}
