package no.runsafe.framework.api.command.argument;

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
}
