package no.runsafe.framework.event.player;

import no.runsafe.framework.server.event.player.RunsafePlayerDropItemEvent;
import no.runsafe.framework.event.IRunsafeEvent;

public interface IPlayerDropItemEvent extends IRunsafeEvent
{
	public boolean OnPlayerDropItem(RunsafePlayerDropItemEvent event);
}
