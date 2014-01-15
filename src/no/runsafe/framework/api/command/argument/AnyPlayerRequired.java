package no.runsafe.framework.api.command.argument;

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
