package no.runsafe.framework.api.command.argument;

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
}
