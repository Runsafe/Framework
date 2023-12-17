package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public class TrailingArgument extends StringArgumentSpecification
{
	public TrailingArgument(String name)
	{
		super(name);
		required = true;
	}

	public TrailingArgument(String name, boolean required)
	{
		super(name);
		if (required)
			require();
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return true;
	}
}
