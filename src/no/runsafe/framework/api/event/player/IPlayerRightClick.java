package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IPlayerRightClick extends IRunsafeEvent
{
	boolean OnPlayerRightClick(RunsafePlayer player, RunsafeMeta usingItem, RunsafeBlock targetBlock);
}

