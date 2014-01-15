package no.runsafe.framework.api.command.argument;

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
}
