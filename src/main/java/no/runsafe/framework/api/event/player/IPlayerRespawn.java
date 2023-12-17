package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;

public interface IPlayerRespawn extends IRunsafeEvent
{
	ILocation OnPlayerRespawn(IPlayer player, ILocation location, boolean isBed);
}
