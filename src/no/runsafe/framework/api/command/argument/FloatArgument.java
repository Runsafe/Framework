package no.runsafe.framework.api.command.argument;

@Deprecated
public class FloatArgument extends DecimalNumber
{
	protected FloatArgument(String name)
	{
		super(name);
	}

	public FloatArgument(String name, boolean required)
	{
		super(name, required);
	}
}
