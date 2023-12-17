package no.runsafe.framework.api.player;

import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.util.Map;

public interface IPlayerControl
{
	@Nullable
	String getLastSeen(IPlayer checker);

	boolean isNew();

	Map<String, String> getData();

	Map<String, String> getBasicData();

	@Nullable
	DateTime lastLogout();

	@Nullable
	String getBanReason();

	@Nullable
	String getDataValue(String key);

	boolean isWhitelisted();

	boolean isNotBanned();

	void kick(String reason);

	boolean hasPlayedBefore();

	boolean isOnline();
}
