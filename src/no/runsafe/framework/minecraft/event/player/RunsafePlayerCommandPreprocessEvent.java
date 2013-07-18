package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class RunsafePlayerCommandPreprocessEvent extends RunsafeCancellablePlayerEvent
{
	public RunsafePlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	public String getMessage()
	{
		return this.event.getMessage();
	}

	public RunsafePlayer getPlayer()
	{
		return new RunsafePlayer(this.event.getPlayer());
	}

	public void setPlayer(RunsafePlayer player)
	{
		this.event.setPlayer((Player) player.getRaw());
	}

	private final PlayerCommandPreprocessEvent event;
}
