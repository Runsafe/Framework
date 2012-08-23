package no.runsafe.framework.event.block;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.block.RunsafeBlockRedstoneEvent;

@Deprecated
public interface IBlockRedstoneEvent extends IRunsafeEvent
{
	public void OnBlockRedstoneEvent(RunsafeBlockRedstoneEvent event);
}

