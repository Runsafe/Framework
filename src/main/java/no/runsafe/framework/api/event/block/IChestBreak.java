package no.runsafe.framework.api.event.block;

import no.runsafe.framework.api.block.IChest;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;

public interface IChestBreak extends IRunsafeEvent
{
	/**
	 * Respond to a user breaking a chest
	 *
	 * @param player The player that broke the block
	 * @param chest  The chest which was broken
	 * @return If not an async event, whether to allow the event
	 */
	boolean OnChestBreak(IPlayer player, IChest chest);
}
