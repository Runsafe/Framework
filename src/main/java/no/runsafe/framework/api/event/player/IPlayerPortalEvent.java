package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPortalEvent;

public interface IPlayerPortalEvent extends IRunsafeEvent
{
	void OnPlayerPortalEvent(RunsafePlayerPortalEvent event);
}
