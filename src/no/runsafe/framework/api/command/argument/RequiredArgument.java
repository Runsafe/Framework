package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public class RequiredArgument extends CommandArgumentSpecification<String>
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

	@Override
	public String getValue(IPlayer context, Map<String, String> params)
	{
		String value = params.get(name);
		if (value != null && !value.isEmpty())
			return value;
		return defaultValue;
	}
}
