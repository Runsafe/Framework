package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public interface IPlayerRightClick extends IRunsafeEvent
{
	boolean OnPlayerRightClick(IPlayer player, RunsafeMeta usingItem, IBlock targetBlock);
}

