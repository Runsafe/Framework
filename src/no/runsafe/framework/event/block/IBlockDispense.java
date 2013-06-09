package no.runsafe.framework.event.block;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.item.meta.RunsafeMeta;

public interface IBlockDispense extends IRunsafeEvent
{
	/**
	 * Respond to a block being dispensed
	 *
	 * @param block The block which was broken
	 * @param item  The item being dispensed
	 * @return If not an async event, whether to allow the event
	 */
	boolean OnBlockDispense(RunsafeBlock block, RunsafeMeta item);
}
