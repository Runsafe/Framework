package no.runsafe.framework.api.event.block;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.block.RunsafeBlockBreakEvent;

public interface IBlockBreakEvent extends IRunsafeEvent
{
	public void OnBlockBreakEvent(RunsafeBlockBreakEvent event);
}
