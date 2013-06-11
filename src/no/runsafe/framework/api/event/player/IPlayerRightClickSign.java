package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.block.RunsafeSign;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IPlayerRightClickSign extends IRunsafeEvent
{
	boolean OnPlayerRightClickSign(RunsafePlayer player, RunsafeMeta usingItem, RunsafeSign sign);
}
