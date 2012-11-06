package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.HashMap;

public interface IPlayerDataProvider
{
	HashMap<String, String> GetPlayerData(RunsafePlayer player);
}
