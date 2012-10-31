package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.block.RunsafeSign;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerRightClickSign extends IRunsafeEvent
{
	boolean OnPlayerRightClickSign(RunsafePlayer player, RunsafeItemStack usingItem, RunsafeSign sign);
}
