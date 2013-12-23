package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class RunsafePlayerCommandPreprocessEvent extends RunsafeCancellablePlayerEvent
{
	public RunsafePlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public String getMessage()
	{
		return event.getMessage();
	}

	@Override
	public IPlayer getPlayer()
	{
		return new RunsafePlayer(event.getPlayer());
	}

	public void setPlayer(RunsafePlayer player)
	{
		event.setPlayer(player.getRaw());
	}

	private final PlayerCommandPreprocessEvent event;
}
