package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;
import org.joda.time.DateTime;

import java.util.HashMap;

public interface IPlayerDataProvider
{
	HashMap<String, String> GetPlayerData(RunsafePlayer player);
	DateTime GetPlayerLogout(RunsafePlayer player);
	String GetPlayerBanReason(RunsafePlayer player);
}
