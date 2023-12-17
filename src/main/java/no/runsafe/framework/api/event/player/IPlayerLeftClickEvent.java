package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerClickEvent;

public interface IPlayerLeftClickEvent extends IRunsafeEvent
{
	void OnPlayerLeftClick(RunsafePlayerClickEvent event);
}
