package no.runsafe.framework.api.hook;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;

public interface IPlayerDataProvider extends IFrameworkHook
{
	/**
	 * Called by {@link RunsafePlayer#getData(ICommandExecutor, String...)} on behalf of plugins that
	 * want to find out various data about a player
	 */
	void GetPlayerData(PlayerData data);
}