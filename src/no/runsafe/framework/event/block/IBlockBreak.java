package no.runsafe.framework.event.block;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IBlockBreak extends IRunsafeEvent
{
	/**
	 * Respond to a user breaking a block
	 *
	 * @param player The player that broke the block
	 * @param block  The block which was broken
	 * @return If not an async event, whether to allow the event
	 */
	boolean OnBlockBreak(RunsafePlayer player, RunsafeBlock block);
}
