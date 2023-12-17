package no.runsafe.framework.api.event.player;

import no.runsafe.framework.minecraft.event.player.RunsafePlayerChangedWorldEvent;
import no.runsafe.framework.api.event.IRunsafeEvent;

public interface IPlayerChangedWorldEvent extends IRunsafeEvent
{
	void OnPlayerChangedWorld(RunsafePlayerChangedWorldEvent event);
}
