package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.internal.command.MapArgument;

import java.util.Map;

public class MapRequired<T> extends MapArgument<T>
{
	protected MapRequired(String name, Map<String, T> values)
	{
		super(name, values);
	}

	@Override
	public boolean isRequired()
	{
		return true;
	}
}
