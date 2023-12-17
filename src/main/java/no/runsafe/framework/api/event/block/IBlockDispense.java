package no.runsafe.framework.api.event.block;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public interface IBlockDispense extends IRunsafeEvent
{
	/**
	 * Respond to a block being dispensed
	 *
	 * @param block The block which was broken
	 * @param item  The item being dispensed
	 * @return If not an async event, whether to allow the event
	 */
	boolean OnBlockDispense(IBlock block, RunsafeMeta item);
}
