package no.runsafe.framework.server.event.player;

import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class RunsafePlayerCommandPreprocessEvent extends RunsafePlayerEvent implements CancellableEvent
{
	public RunsafePlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent toWrap)
	{
		super(toWrap);
        this.event = toWrap;
	}

    @Override
    public boolean getCancelled()
    {
        return event.isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel)
    {
        event.setCancelled(cancel);
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
