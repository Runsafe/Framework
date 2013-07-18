package no.runsafe.framework.api.event.hanging;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.entity.RunsafePainting;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IPaintingPlaced extends IRunsafeEvent
{
	boolean OnPaintingPlaced(RunsafePlayer player, RunsafePainting painting);
}
