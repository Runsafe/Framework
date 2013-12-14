package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.event.IFakeableEvent;
import no.runsafe.framework.api.event.player.IPlayerKickEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.Player;
import org.bukkit.event.player.PlayerKickEvent;

public class RunsafePlayerKickEvent extends RunsafePlayerEvent implements IFakeableEvent
{
	public RunsafePlayerKickEvent(PlayerKickEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
		kicker = Player.Get().getKicker(toWrap.getPlayer().getName());
	}

	public String getLeaveMessage()
	{
		return event.getLeaveMessage();
	}

	public void setLeaveMessage(String message)
	{
		event.setLeaveMessage(message);
	}

	public String getReason()
	{
		return event.getReason();
	}

	public void setReason(String reason)
	{
		event.setReason(reason);
	}

	@SuppressWarnings("MethodWithMultipleLoops")
	@Override
	public boolean Fire()
	{
		isFake = true;
		for (IPlayerKickEvent listener : RunsafePlugin.getAllPluginComponents(IPlayerKickEvent.class))
			listener.OnPlayerKick(this);
		return true;
	}

	@Override
	public boolean isFake()
	{
		return isFake;
	}

	public IPlayer getKicker()
	{
		return kicker;
	}

	private final PlayerKickEvent event;
	private final IPlayer kicker;
	private boolean isFake;
}
