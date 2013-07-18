package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IPlayerTeleport extends IRunsafeEvent
{
	boolean OnPlayerTeleport(RunsafePlayer player, RunsafeLocation from, RunsafeLocation to);
}
