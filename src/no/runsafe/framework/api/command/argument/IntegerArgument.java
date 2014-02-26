package no.runsafe.framework.api.command.argument;

public class IntegerArgument extends WholeNumber
{
	protected IntegerArgument(String name)
	{
		super(name);
	}

	public IntegerArgument(String name, boolean required)
	{
		super(name, required);
	}
}
