package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;

public interface IPlayerPortal extends IRunsafeEvent
{
	boolean OnPlayerPortal(IPlayer player, ILocation from, ILocation to);
}
