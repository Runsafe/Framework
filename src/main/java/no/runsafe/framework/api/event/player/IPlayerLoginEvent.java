package no.runsafe.framework.api.event.player;

import no.runsafe.framework.minecraft.event.player.RunsafePlayerLoginEvent;
import no.runsafe.framework.api.event.IRunsafeEvent;

public interface IPlayerLoginEvent extends IRunsafeEvent
{
	void OnPlayerLogin(RunsafePlayerLoginEvent event);
}
