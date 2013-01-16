package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerPvPFlag extends FrameworkHook
{
	boolean isFlaggedForPvP(RunsafePlayer player);
}
