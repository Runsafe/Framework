package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;

public interface IPlayerMove extends IRunsafeEvent
{
	boolean OnPlayerMove(IPlayer player, ILocation from, ILocation to);
}
