package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.event.IFakeableEvent;
import no.runsafe.framework.api.event.player.IPlayerJoinEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class RunsafePlayerJoinEvent extends RunsafePlayerEvent implements IFakeableEvent
{
	public RunsafePlayerJoinEvent(PlayerJoinEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public String getJoinMessage()
	{
		return event.getJoinMessage();
	}

	public void setJoinMessage(String message)
	{
		event.setJoinMessage(message);
	}

	@SuppressWarnings("MethodWithMultipleLoops")
	@Override
	public boolean Fire()
	{
		isFake = true;
		for (IPlayerJoinEvent listener : RunsafePlugin.getAllPluginComponents(IPlayerJoinEvent.class))
			listener.OnPlayerJoinEvent(this);
		return true;
	}

	@Override
	public boolean isFake()
	{
		return isFake;
	}

	private final PlayerJoinEvent event;
	private boolean isFake;
}
