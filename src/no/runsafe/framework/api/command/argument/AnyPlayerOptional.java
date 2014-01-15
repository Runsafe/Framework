package no.runsafe.framework.api.command.argument;

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
}
