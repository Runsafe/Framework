package no.runsafe.framework.server.player;

import no.runsafe.framework.event.player.IPlayerLoginEvent;
import no.runsafe.framework.event.player.IPlayerQuitEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerLoginEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerQuitEvent;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PlayerByPermissionProvider implements IPlayerLoginEvent, IPlayerQuitEvent, IPlayerByPermissionProvider
{
	public PlayerByPermissionProvider(Server server)
	{
		this.server = server;
		permissionMaps = new HashMap<String, HashMap<String, RunsafePlayer>>();
	}

	@Override
	public void OnPlayerLogin(RunsafePlayerLoginEvent event)
	{
		checkPlayer(event.getPlayer());
	}

	@Override
	public void OnPlayerQuit(RunsafePlayerQuitEvent event)
	{
		if (permissionMaps.isEmpty())
			return;

		for (Map<String, RunsafePlayer> players : permissionMaps.values())
			if (players.containsKey(event.getPlayer().getName()))
				players.remove(event.getPlayer().getName());
	}

	@Override
	public void checkPlayer(RunsafePlayer player)
	{
		for (String permission : permissionMaps.keySet())
			if (player.hasPermission(permission))
				permissionMaps.get(permission).put(player.getName(), player);
	}

	@Override
	public boolean watchPermission(String permission)
	{
		if (permissionMaps.containsKey(permission))
			return false;

		permissionMaps.put(permission, new HashMap<String, RunsafePlayer>());
		for (Player player : server.getOnlinePlayers())
			if (player.hasPermission(permission))
				permissionMaps.get(permission).put(player.getName(), new RunsafePlayer(player));

		return true;
	}

	@Override
	public Collection<RunsafePlayer> getPlayersWithPermission(String permission)
	{
		if (permissionMaps == null || !permissionMaps.containsKey(permission))
			return null;

		return permissionMaps.get(permission).values();
	}

	private HashMap<String, HashMap<String, RunsafePlayer>> permissionMaps;
	private Server server;
}
