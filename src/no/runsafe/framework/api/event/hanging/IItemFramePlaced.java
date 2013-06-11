package no.runsafe.framework.api.event.hanging;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.entity.RunsafeItemFrame;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IItemFramePlaced extends IRunsafeEvent
{
	public boolean OnItemFramePlaced(RunsafePlayer player, RunsafeItemFrame itemFrame);
}
