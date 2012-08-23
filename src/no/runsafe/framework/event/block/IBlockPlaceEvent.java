package no.runsafe.framework.event.block;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.block.RunsafeBlockPlaceEvent;

/**
 * Please implement IBlockPlace unless you need the extra features provided here.
 */
@Deprecated
public interface IBlockPlaceEvent extends IRunsafeEvent
{
	public void OnBlockPlaceEvent(RunsafeBlockPlaceEvent event);
}

