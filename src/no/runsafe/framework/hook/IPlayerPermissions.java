package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.List;

public interface IPlayerPermissions extends FrameworkHook
{
	List<String> getUserGroups(RunsafePlayer player);
}
