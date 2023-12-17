package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.internal.command.argument.MapArgument;

import java.util.Map;

public class MapRequired<T> extends MapArgument<T>
{
	public MapRequired(String name, Map<String, T> values)
	{
		super(name, values);
	}

	@Override
	public boolean isRequired()
	{
		return true;
	}
}
