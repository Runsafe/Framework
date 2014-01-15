package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;

import java.util.List;
import java.util.Map;

public interface IArgumentList extends Map<String, String>
{
	IWorld getWorld(String param);
	IPlayer getPlayer(String param);
	List<IPlayer> getPlayers(String param);
	Enum<?> getEnum(String param);
	boolean isAborted();
}
