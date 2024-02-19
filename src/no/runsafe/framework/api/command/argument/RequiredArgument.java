package no.runsafe.framework.api.command.argument;

public class RequiredArgument extends StringArgumentSpecification
{
	public RequiredArgument(String name)
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
		return false;
	}
}
