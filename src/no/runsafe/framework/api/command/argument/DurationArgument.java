package no.runsafe.framework.api.command.argument;

@Deprecated
public class DurationArgument extends Duration
{
	protected DurationArgument(String name)
	{
		super(name);
	}

	public DurationArgument(boolean required)
	{
		super(required);
	}

	public DurationArgument(String name, boolean required)
	{
		super(name, required);
	}
}
