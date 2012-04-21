package no.runsafe.framework.server.event.block;

import no.runsafe.framework.server.RunsafeBlock;
import no.runsafe.framework.server.event.RunsafeEvent;
import org.bukkit.event.block.BlockEvent;

public class RunsafeBlockEvent extends RunsafeEvent
{
    public RunsafeBlockEvent(BlockEvent toWrap)
    {
        super(toWrap);
        event = toWrap;
    }

    public RunsafeBlock getBlock()
    {
        return new RunsafeBlock(this.event.getBlock());
    }

    private BlockEvent event;
}
