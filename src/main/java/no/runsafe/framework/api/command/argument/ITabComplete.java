package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.List;

public interface ITabComplete
{
	List<String> getAlternatives(IPlayer executor, String partial);
}
