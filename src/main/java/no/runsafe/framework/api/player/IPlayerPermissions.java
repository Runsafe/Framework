package no.runsafe.framework.api.player;

import com.google.common.collect.ImmutableList;

public interface IPlayerPermissions
{
	ImmutableList<String> getGroups();

	boolean setGroup(String group);

	boolean hasPermission(String permission);

	void addPermission(String permission);

	void addPermission(String permission, String world);

	void removePermission(String permission);

	void removePermission(String permission, String world);
}
