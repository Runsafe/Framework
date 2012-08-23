package no.runsafe.framework.event.block;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.block.RunsafeBlockDispenseEvent;

/**
 * Please consider implementing IBlockDispense instead, unless you need the additional features provided here.
 */
@Deprecated
public interface IBlockDispenseEvent extends IRunsafeEvent
{
	public void OnBlockDispenseEvent(RunsafeBlockDispenseEvent event);
}
