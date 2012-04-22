package no.runsafe.framework.server.player;

import java.util.Collection;

public interface IPlayerByPermissionProvider
{
	boolean watchPermission(String permission);

	void checkPlayer(RunsafePlayer player);

	Collection<RunsafePlayer> getPlayersWithPermission(String permission);
}
