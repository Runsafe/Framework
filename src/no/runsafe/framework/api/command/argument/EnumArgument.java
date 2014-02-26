package no.runsafe.framework.api.command.argument;

public class EnumArgument extends Enum
{
	protected EnumArgument(String name, java.lang.Enum<?>[] values)
	{
		super(name, values);
	}

	public EnumArgument(String name, java.lang.Enum<?>[] values, boolean required)
	{
		super(name, values, required);
	}

	public EnumArgument(String name, java.lang.Enum<?>[] values, java.lang.Enum<?> defaultValue)
	{
		super(name, values, defaultValue);
	}

	public EnumArgument(String name, Iterable<String> values, boolean required)
	{
		super(name, values, required);
	}

	public EnumArgument(String name, Iterable<String> values, String defaultValue)
	{
		super(name, values, defaultValue);
	}
}
