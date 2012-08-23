package no.runsafe.framework.event.block;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IBlockPlace extends IRunsafeEvent
{
	/**
	 * Respond to a player placing a block
	 *
	 * @param player The player placing the block
	 * @param block  The block being placed
	 * @return If not an async event, whether to allow the event
	 */
	public boolean OnBlockPlace(RunsafePlayer player, RunsafeBlock block);
}
