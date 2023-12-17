package no.runsafe.framework.api.hook;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;

import java.util.List;

public interface IPlayerPermissions extends IFrameworkHook
{
	/**
	 * Called by {@link RunsafePlayer#getGroups()} to resolve a players group memberships
	 */
	List<String> getUserGroups(IPlayer player);

	List<String> getGroups();

	boolean setGroup(IPlayer player, String group);

	List<String> getGroupPermissions(String groupName);

	List<String> getPlayerPermissions(IPlayer player);

	void addPermission(IPlayer player, String permission, String world);

	void addPermission(IPlayer player, String permission);

	void removePermission(IPlayer player, String permission, String world);

	void removePermission(IPlayer player, String permission);
}
