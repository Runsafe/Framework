package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.block.ISign;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public interface IPlayerRightClickSign extends IRunsafeEvent
{
	boolean OnPlayerRightClickSign(IPlayer player, RunsafeMeta usingItem, ISign sign);
}
