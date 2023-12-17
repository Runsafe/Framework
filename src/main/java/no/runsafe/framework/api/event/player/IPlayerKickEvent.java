package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerKickEvent;

public interface IPlayerKickEvent extends IRunsafeEvent
{
	void OnPlayerKick(RunsafePlayerKickEvent event);
}
