package no.runsafe.framework.api.event.hanging;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.entity.RunsafeItemFrame;

public interface IItemFramePlaced extends IRunsafeEvent
{
	boolean OnItemFramePlaced(IPlayer player, RunsafeItemFrame itemFrame);
}
