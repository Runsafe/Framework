package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.internal.command.argument.OnlinePlayerArgument;

public class OnlinePlayerOptional extends OnlinePlayerArgument
{
	public OnlinePlayerOptional()
	{
		super(false, false);
	}

	public OnlinePlayerOptional(String name)
	{
		super(name, false, false);
	}

	@Override
	public boolean isRequired()
	{
		return false;
	}
}
