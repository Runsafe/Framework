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
	@Nullable
	IWorld getWorld(String param);
	@Nullable
	IPlayer getPlayer(String param);
	@Nonnull
	List<IPlayer> getPlayers(String param);
	@Nullable
	Enum<?> getEnum(String param);
	@Nullable
	<T> T getMappedValue(String param);
	@Nullable
	<T> T getValue(String param);
	@Nonnull
	<T> Collection<T> getList(String param);
	boolean isAborted();
}
