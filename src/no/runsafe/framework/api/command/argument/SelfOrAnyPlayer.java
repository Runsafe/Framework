package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.internal.command.argument.AnyPlayerArgument;

@Deprecated
public class SelfOrAnyPlayer extends AnyPlayerArgument
{
	public SelfOrAnyPlayer()
	{
		super(false, true);
	}

	public SelfOrAnyPlayer(String name)
	{
		super(name, false, true);
	}

	@Override
	public boolean isRequired()
	{
		return false;
	}
}
