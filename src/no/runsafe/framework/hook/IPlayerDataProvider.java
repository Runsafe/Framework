package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.HashMap;

public interface IPlayerDataProvider extends FrameworkHook
{
	/**
	 * Called by {@link no.runsafe.framework.server.player.RunsafePlayer#getData()} on behalf of plugins that
	 * want to find out various data about a player
	 */
	HashMap<String, String> GetPlayerData(RunsafePlayer player);
}

