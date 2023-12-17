package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public class OptionalArgument extends StringArgumentSpecification
{
	public OptionalArgument(String name)
	{
		super(name);
	}

	@Deprecated
	public OptionalArgument(String name, String defaultValue)
	{
		super(name);
		withDefault(defaultValue);
	}

	@Override
	public boolean isRequired()
	{
		return false;
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}
}
