package no.runsafe.framework.api.hook;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.List;

public interface IPlayerPermissions extends IFrameworkHook
{
	boolean setUserGroup(RunsafePlayer player, String group);

	/**
	 * Called by {@link no.runsafe.framework.minecraft.player.RunsafePlayer#getGroups()} to resolve a players group memberships
	 */
	List<String> getUserGroups(RunsafePlayer player);

	List<String> getGroupPermissions(String groupName);

	List<String> getPlayerPermissions(RunsafePlayer player);
}
