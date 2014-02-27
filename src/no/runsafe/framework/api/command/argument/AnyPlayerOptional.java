package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.command.argument.AnyPlayerArgument;

@Deprecated
public class AnyPlayerOptional extends AnyPlayerArgument
{
	public AnyPlayerOptional()
	{
		super(false, false);
	}

	public AnyPlayerOptional(String name)
	{
		super(name, false, false);
	}

	@Override
	public boolean isRequired()
	{
		return false;
	}
}
