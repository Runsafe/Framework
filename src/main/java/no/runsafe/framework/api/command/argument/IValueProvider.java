package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public interface IValueProvider<T>
{
	T getValue(IPlayer context, Map<String, String> params);
}
