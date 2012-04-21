package no.runsafe.framework.event.block;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.block.RunsafeBlockBreakEvent;

public interface IBlockBreakEvent extends IRunsafeEvent
{
    public void OnBlockBreakEvent(RunsafeBlockBreakEvent event);
}
