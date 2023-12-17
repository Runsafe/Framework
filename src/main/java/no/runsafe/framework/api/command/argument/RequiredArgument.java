package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public class RequiredArgument extends StringArgumentSpecification
{
	public RequiredArgument(String name)
	{
		super(name);
	}

	@Override
	public boolean isRequired()
	{
		return true;
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}
}
