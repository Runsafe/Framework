package no.runsafe.framework.event.hanging;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.entity.RunsafeItemFrame;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IItemFramePlaced extends IRunsafeEvent
{
	public boolean OnItemFramePlaced(RunsafePlayer player, RunsafeItemFrame itemFrame);
}
