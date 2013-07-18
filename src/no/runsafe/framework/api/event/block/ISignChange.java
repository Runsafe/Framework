package no.runsafe.framework.api.event.block;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface ISignChange extends IRunsafeEvent
{
	/**
	 * Respond to a user changing a sign
	 *
	 * @param player The player that changed the sign
	 * @param block  The sign block that was changed
	 * @return If not an async event, whether to allow the event
	 */
	boolean OnSignChange(RunsafePlayer player, RunsafeBlock block, String... text);
}
