package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPreLoginEvent;

public interface IPlayerPreLoginEvent extends IRunsafeEvent
{
	void OnBeforePlayerLogin(RunsafePlayerPreLoginEvent event);
}
