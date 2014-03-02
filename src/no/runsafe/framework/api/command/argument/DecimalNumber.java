package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public class DecimalNumber extends CommandArgumentSpecification<java.lang.Float>
{
	public DecimalNumber(String name)
	{
		super(name);
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}

	@Override
	public java.lang.Float getValue(IPlayer context, Map<String, String> params)
	{
		try
		{
			if (params.get(name) == null || params.get(name).isEmpty())
				return defaultValue;
			return java.lang.Float.parseFloat(params.get(name));
		}
		catch (NumberFormatException e)
		{
			return defaultValue;
		}
	}
}
