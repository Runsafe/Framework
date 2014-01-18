package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.internal.command.argument.OnlinePlayerArgument;

public class OnlinePlayerRequired extends OnlinePlayerArgument
{
	public OnlinePlayerRequired()
	{
		super(true, false);
	}

	public OnlinePlayerRequired(String name)
	{
		super(name, true, false);
	}

	@Override
	public boolean isRequired()
	{
		return true;
	}
}
