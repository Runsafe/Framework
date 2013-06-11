package no.runsafe.framework.api.event.block;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.block.RunsafeBlockRedstoneEvent;

public interface IBlockRedstone extends IRunsafeEvent
{
	public void OnBlockRedstoneEvent(RunsafeBlockRedstoneEvent event);
}
