package no.runsafe.framework.server.event.block;

import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.event.block.BlockPlaceEvent;

public class RunsafeBlockPlaceEvent extends RunsafeBlockEvent implements CancellableEvent
{
    public RunsafeBlockPlaceEvent(BlockPlaceEvent toWrap)
    {
        super(toWrap);
        event = toWrap;
    }

    //Used in default MC spawn region, not linked to WorldGuard
    public boolean canBuild()
    {
        return event.canBuild();
    }

    public void setBuild(boolean canBuild)
    {
        event.setBuild(canBuild);
    }

    public RunsafeBlock getBlock()
    {
        return new RunsafeBlock(event.getBlock());
    }

    public RunsafeBlock getBlockAgainst()
    {
        return new RunsafeBlock(event.getBlockAgainst());
    }

    public RunsafeBlock getBlockPlaced()
    {
        return new RunsafeBlock(event.getBlockPlaced());
    }

    public RunsafePlayer getPlayer()
    {
        return new RunsafePlayer(event.getPlayer());
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

    private BlockPlaceEvent event;
}
