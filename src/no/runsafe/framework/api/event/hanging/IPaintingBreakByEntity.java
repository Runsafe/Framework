package no.runsafe.framework.api.event.hanging;

import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.entity.RunsafePainting;

public interface IPaintingBreakByEntity extends IRunsafeEvent
{
	boolean OnPaintingBreak(IEntity remover, RunsafePainting painting);
}
