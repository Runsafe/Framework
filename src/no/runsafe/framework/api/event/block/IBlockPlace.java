package no.runsafe.framework.api.event.block;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IBlockPlace extends IRunsafeEvent
{
	/**
	 * Respond to a player placing a block
	 *
	 * @param player The player placing the block
	 * @param block  The block being placed
	 * @return If not an async event, whether to allow the event
	 */
	boolean OnBlockPlace(RunsafePlayer player, RunsafeBlock block);
}
