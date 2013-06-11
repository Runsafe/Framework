package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.event.player.IPlayerKickEvent;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.api.event.IFakeableEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.event.player.PlayerKickEvent;

public class RunsafePlayerKickEvent extends RunsafePlayerEvent implements IFakeableEvent
{
	public RunsafePlayerKickEvent(PlayerKickEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
		this.kicker = RunsafeServer.Instance.getKicker(toWrap.getPlayer().getName());
	}

	public String getLeaveMessage()
	{
		return this.event.getLeaveMessage();
	}

	public void setLeaveMessage(String message)
	{
		this.event.setLeaveMessage(message);
	}

	public String getReason()
	{
		return this.event.getReason();
	}

	public void setReason(String reason)
	{
		this.event.setReason(reason);
	}

	public void Fire()
	{
		isFake = true;
		for (IKernel plugin : RunsafePlugin.Instances.values())
			for (IPlayerKickEvent listener : plugin.getComponents(IPlayerKickEvent.class))
				listener.OnPlayerKick(this);
	}

	@Override
	public boolean isFake()
	{
		return isFake;
	}

	public RunsafePlayer getKicker()
	{
		return kicker;
	}

	private final PlayerKickEvent event;
	private final RunsafePlayer kicker;
	private boolean isFake = false;
}
