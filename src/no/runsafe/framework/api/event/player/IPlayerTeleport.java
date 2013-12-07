package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.RunsafeLocation;

public interface IPlayerTeleport extends IRunsafeEvent
{
	boolean OnPlayerTeleport(IPlayer player, RunsafeLocation from, RunsafeLocation to);
}
