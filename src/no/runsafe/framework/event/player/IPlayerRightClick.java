package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerRightClick extends IRunsafeEvent
{
	boolean OnPlayerRightClick(RunsafePlayer player, RunsafeItemStack usingItem, RunsafeBlock targetBlock);
}

