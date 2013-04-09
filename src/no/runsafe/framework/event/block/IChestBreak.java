package no.runsafe.framework.event.block;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.block.RunsafeChest;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IChestBreak extends IRunsafeEvent
{
	/**
	 * Respond to a user breaking a chest
	 *
	 * @param player The player that broke the block
	 * @param chest  The chest which was broken
	 * @return If not an async event, whether to allow the event
	 */
	boolean OnChestBreak(RunsafePlayer player, RunsafeChest chest);
}
