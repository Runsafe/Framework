package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerFishEvent;

public interface IPlayerFishEvent extends IRunsafeEvent
{
	void OnPlayerFish(RunsafePlayerFishEvent event);
}
