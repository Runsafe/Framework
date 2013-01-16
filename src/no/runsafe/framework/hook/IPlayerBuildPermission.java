package no.runsafe.framework.hook;

import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerBuildPermission extends FrameworkHook
{
	boolean blockPlayerBuilding(RunsafePlayer player, RunsafeLocation location);
}
