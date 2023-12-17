package no.runsafe.framework.api.event.player;

import no.runsafe.framework.minecraft.event.player.RunsafePlayerDropItemEvent;
import no.runsafe.framework.api.event.IRunsafeEvent;

public interface IPlayerDropItemEvent extends IRunsafeEvent
{
	void OnPlayerDropItem(RunsafePlayerDropItemEvent event);
}
