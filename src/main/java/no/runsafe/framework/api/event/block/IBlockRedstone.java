package no.runsafe.framework.api.event.block;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.block.RunsafeBlockRedstoneEvent;

public interface IBlockRedstone extends IRunsafeEvent
{
	void OnBlockRedstoneEvent(RunsafeBlockRedstoneEvent event);
}
