package no.runsafe.framework.server.event.player;

import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class RunsafePlayerInteractEntityEvent extends RunsafePlayerEvent implements CancellableEvent
{
    public RunsafePlayerInteractEntityEvent(PlayerInteractEntityEvent toWrap)
    {
        super(toWrap);
        event = toWrap;
    }

    public RunsafeEntity getRightClicked()
    {
        if (this.event.getRightClicked() instanceof Player)
            return new RunsafePlayer((Player) this.event.getRightClicked());
        else
            return new RunsafeEntity(this.event.getRightClicked());
    }

    public RunsafePlayer getPlayer()
    {
        return new RunsafePlayer(this.event.getPlayer());
    }

    // TODO: Cast HandlerList to Bukkit
    public HandlerList getHandlers()
    {
        return this.event.getHandlers();
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

    private final PlayerInteractEntityEvent event;
}