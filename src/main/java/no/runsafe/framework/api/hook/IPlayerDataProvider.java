package no.runsafe.framework.api.hook;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;

import java.util.Map;

public interface IPlayerDataProvider extends IFrameworkHook
{
	/**
	 * Called by {@link RunsafePlayer#getData()} on behalf of plugins that
	 * want to find out various data about a player
	 */
	Map<String, String> GetPlayerData(IPlayer player);
}

