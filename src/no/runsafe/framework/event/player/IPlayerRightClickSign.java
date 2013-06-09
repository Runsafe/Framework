package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.block.RunsafeSign;
import no.runsafe.framework.server.item.meta.RunsafeMeta;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerRightClickSign extends IRunsafeEvent
{
	boolean OnPlayerRightClickSign(RunsafePlayer player, RunsafeMeta usingItem, RunsafeSign sign);
}
