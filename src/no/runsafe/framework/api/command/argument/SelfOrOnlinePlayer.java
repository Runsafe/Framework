package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.internal.command.argument.OnlinePlayerArgument;

@Deprecated
public class SelfOrOnlinePlayer extends OnlinePlayerArgument
{
	public SelfOrOnlinePlayer()
	{
		super(false, true);
	}

	public SelfOrOnlinePlayer(String name)
	{
		super(name, false, true);
	}

	@Override
	public boolean isRequired()
	{
		return false;
	}
}
