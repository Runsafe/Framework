package no.runsafe.framework.api.command.argument;

public class TrailingArgument extends CommandArgumentSpecification
{
	public TrailingArgument(String name)
	{
		super(name);
	}

	@Override
	public boolean isRequired()
	{
		return true;
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return true;
	}
}
