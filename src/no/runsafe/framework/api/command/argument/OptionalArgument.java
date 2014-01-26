package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;

import javax.annotation.Nullable;

public class OptionalArgument extends CommandArgumentSpecification implements IValueExpander
{
	public OptionalArgument(String name)
	{
		super(name);
	}

	public OptionalArgument(String name, String defaultValue)
	{
		super(name);
		this.defaultValue = defaultValue;
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

	@Nullable
	@Override
	public String expand(ICommandExecutor context, @Nullable String value)
	{
		if (value != null)
			return value;
		return defaultValue;
	}

	private String defaultValue;
}
