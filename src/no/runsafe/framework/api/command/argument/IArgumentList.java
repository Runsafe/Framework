package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public interface IArgumentList extends Map<String, String>
{
	@Nullable
	IWorld getWorld(String param);
	@Nullable
	IPlayer getPlayer(String param);
	@Nullable
	List<IPlayer> getPlayers(String param);
	@Nullable
	Enum<?> getEnum(String param);

	@Nullable
	<T> T getMappedValue(String param);

	boolean isAborted();
}
