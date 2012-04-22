package no.runsafe.framework.server.event.block;

import no.runsafe.framework.server.event.CancellableEvent;
import org.bukkit.event.block.BlockRedstoneEvent;

public class RunsafeBlockRedstoneEvent extends RunsafeBlockEvent
{
    public RunsafeBlockRedstoneEvent(BlockRedstoneEvent toWrap)
    {
        super(toWrap);
        event = toWrap;
    }

    private BlockRedstoneEvent event;
}
