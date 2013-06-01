package no.runsafe.framework.event.hanging;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.entity.RunsafePainting;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPaintingPlaced extends IRunsafeEvent
{
	public boolean OnPaintingPlaced(RunsafePlayer player, RunsafePainting painting);
}
