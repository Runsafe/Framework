package no.runsafe.framework.api.player;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.hook.PlayerData;

import javax.annotation.Nullable;
import java.time.Instant;
import java.util.Map;

public interface IPlayerControl
{
	@Nullable
	String getLastSeen(IPlayer checker);

	boolean isNew();

	Map<String, String> getData(ICommandExecutor context, String... filter);

	void getBasicData(PlayerData data);

	@Nullable
	Instant lastLogout();

	@Nullable
	String getBanReason();

	boolean isWhitelisted();

	boolean isNotBanned();

	void kick(String reason);

	boolean hasPlayedBefore();

	boolean isOnline();
}
