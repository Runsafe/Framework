package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;

public interface IPlayerTeleport extends IRunsafeEvent
{
	boolean OnPlayerTeleport(IPlayer player, ILocation from, ILocation to);
}
