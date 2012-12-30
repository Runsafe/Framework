package no.runsafe.framework.server.event.player;

import no.runsafe.framework.IKernel;
import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.player.IPlayerQuitEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;

public class RunsafePlayerQuitEvent extends RunsafePlayerEvent
{
	public RunsafePlayerQuitEvent(PlayerQuitEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public String getQuitMessage()
	{
		return event.getQuitMessage();
	}

	public void setQuitMessage(String message)
	{
		event.setQuitMessage(message);
	}

	public void Fire()
	{
		for (IKernel plugin : RunsafePlugin.Instances.values())
			for (IPlayerQuitEvent listener : plugin.getComponents(IPlayerQuitEvent.class))
				listener.OnPlayerQuit(this);
	}

	private final PlayerQuitEvent event;
}
