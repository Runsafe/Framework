package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.internal.command.argument.AnyPlayerArgument;

public class AnyPlayerRequired extends AnyPlayerArgument
{
	public AnyPlayerRequired()
	{
		super(true, false);
	}

	public AnyPlayerRequired(String name)
	{
		super(name, true, false);
	}

	@Override
	public boolean isRequired()
	{
		return true;
	}
}
