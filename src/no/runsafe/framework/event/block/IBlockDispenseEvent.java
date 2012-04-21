package no.runsafe.framework.event.block;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.block.RunsafeBlockDispenseEvent;

public interface IBlockDispenseEvent extends IRunsafeEvent
{
    public void OnBlockDispenseEvent(RunsafeBlockDispenseEvent event);
}
