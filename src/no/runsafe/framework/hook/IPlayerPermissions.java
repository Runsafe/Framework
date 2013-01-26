package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.List;

public interface IPlayerPermissions extends FrameworkHook
{
	/**
	 * Called by {@link no.runsafe.framework.server.player.RunsafePlayer#getGroups()} to resolve a players group memberships
	 */
	List<String> getUserGroups(RunsafePlayer player);
}
