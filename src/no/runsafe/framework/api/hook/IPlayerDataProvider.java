package no.runsafe.framework.api.hook;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.HashMap;

public interface IPlayerDataProvider extends IFrameworkHook
{
	/**
	 * Called by {@link no.runsafe.framework.minecraft.player.RunsafePlayer#getData()} on behalf of plugins that
	 * want to find out various data about a player
	 */
	HashMap<String, String> GetPlayerData(RunsafePlayer player);
}

