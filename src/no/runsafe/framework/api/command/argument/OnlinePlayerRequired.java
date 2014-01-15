package no.runsafe.framework.api.command.argument;

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
}
