package no.runsafe.framework.api.hook;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.Map;

public interface IPlayerDataProvider extends IFrameworkHook
{
	/**
	 * Called by {@link RunsafePlayer#getData()} on behalf of plugins that
	 * want to find out various data about a player
	 */
	Map<String, String> GetPlayerData(RunsafePlayer player);
}

