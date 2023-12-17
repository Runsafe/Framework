package no.runsafe.framework.api.hook;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;
import no.runsafe.framework.minecraft.player.RunsafeFakePlayer;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface IPlayerExtensions
{
	@Nullable
	String seen(RunsafePlayer player, IPlayer checker);
	String decorate(IPlayer player);
	boolean isNew(RunsafePlayer player);
	Map<String, String> data(RunsafePlayer player);
	@Nullable
	DateTime logout(RunsafePlayer player);
	@Nullable
	String banReason(RunsafePlayer player);
	boolean shouldNotSee(RunsafePlayer player, IPlayer target);
	boolean isVanished(RunsafePlayer player);
	boolean isPvPFlagged(RunsafePlayer player);
	ImmutableList<String> getGroups(RunsafePlayer player);
	boolean setGroup(RunsafePlayer player, String group);
	boolean canBuildNow(RunsafePlayer player);
	boolean hasPermission(RunsafeFakePlayer player, ImmutableList<String> memberOf, String permission);
	List<String> getGroups();
	List<String> find(String playerName);
	@Nullable
	UUID getUniqueId(String playerName);
	String getPlayerName(UUID playerId);
	void addPermission(IPlayer player, String permission, String world);
	void addPermission(IPlayer player, String permission);
	void removePermission(IPlayer player, String permission, String world);
	void removePermission(IPlayer player, String permission);
}
