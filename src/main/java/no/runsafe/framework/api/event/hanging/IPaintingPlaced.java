package no.runsafe.framework.api.event.hanging;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.entity.RunsafePainting;

public interface IPaintingPlaced extends IRunsafeEvent
{
	boolean OnPaintingPlaced(IPlayer player, RunsafePainting painting);
}
