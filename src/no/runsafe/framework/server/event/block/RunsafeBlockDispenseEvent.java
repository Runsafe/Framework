package no.runsafe.framework.server.event.block;

import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerEvent;
import org.bukkit.event.block.BlockDispenseEvent;

public class RunsafeBlockDispenseEvent extends RunsafeBlockEvent implements CancellableEvent
{
    public RunsafeBlockDispenseEvent(BlockDispenseEvent toWrap)
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

    private BlockDispenseEvent event;
}
