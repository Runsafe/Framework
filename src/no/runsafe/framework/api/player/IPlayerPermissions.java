package no.runsafe.framework.api.player;

import com.google.common.collect.ImmutableList;

public interface IPlayerPermissions
{
	ImmutableList<String> getGroups();

	boolean setGroup(String group);

	boolean hasPermission(String permission);
}
