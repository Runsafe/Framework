package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.RunsafeLocation;

public interface IPlayerPortal extends IRunsafeEvent
{
	boolean OnPlayerPortal(IPlayer player, RunsafeLocation from, RunsafeLocation to);
}
