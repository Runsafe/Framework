package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IArgumentList extends Map<String, String>
{
	@Deprecated
	@Nullable
	IWorld getWorld(String param);
	@Deprecated
	@Nullable
	IPlayer getPlayer(String param);
	@Deprecated
	@Nonnull
	List<IPlayer> getPlayers(String param);
	@Deprecated
	@Nullable
	Enum<?> getEnum(String param);
	@Deprecated
	@Nullable
	<T> T getMappedValue(String param);
	@Nullable
	<T> T getValue(String param);
	@Deprecated
	@Nonnull
	<T> Collection<T> getList(String param);
	boolean isAborted();
}
