package no.runsafe.framework.api.command.argument;

public class OptionalArgument extends CommandArgumentSpecification
{
	public OptionalArgument(String name)
	{
		super(name);
	}

	@Override
	public boolean isRequired()
	{
		return false;
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}
}
