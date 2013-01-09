package no.runsafe.framework.server.event.player;

import no.runsafe.framework.IKernel;
import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.event.player.IPlayerJoinEvent;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.event.IFakeableEvent;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.event.player.PlayerJoinEvent;

public class RunsafePlayerJoinEvent extends RunsafePlayerEvent implements IFakeableEvent
{
	public RunsafePlayerJoinEvent(PlayerJoinEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafePlayer getPlayer()
	{
		return ObjectWrapper.convert(event.getPlayer());
	}

	public String getJoinMessage()
	{
		return event.getJoinMessage();
	}

	public void setJoinMessage(String message)
	{
		event.setJoinMessage(message);
	}

	public void Fire()
	{
		isFake = true;
		for (IKernel plugin : RunsafePlugin.Instances.values())
			for (IPlayerJoinEvent listener : plugin.getComponents(IPlayerJoinEvent.class))
				listener.OnPlayerJoinEvent(this);
	}

	@Override
	public boolean isFake()
	{
		return isFake;
	}

	private final PlayerJoinEvent event;
	private boolean isFake;
}
