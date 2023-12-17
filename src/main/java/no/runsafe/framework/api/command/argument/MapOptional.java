package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.command.argument.MapArgument;

import javax.annotation.Nullable;
import java.util.Map;

public class MapOptional<T> extends MapArgument<T>
{
	public MapOptional(String name, Map<String, T> values)
	{
		super(name, values);
	}

	@Override
	public boolean isRequired()
	{
		return false;
	}

	@Nullable
	@Override
	public T getValue(IPlayer context, Map<String, String> params)
	{
		if (!params.containsKey(name))
			return null;

		return super.getValue(context, params);
	}
}
