package no.runsafe.framework.api.command.argument;

public class TrailingArgument extends CommandArgumentSpecification
{
	public TrailingArgument(String name)
	{
		super(name);
		required = true;
	}

	public TrailingArgument(String name, boolean required)
	{
		super(name);
		this.required = required;
	}

	@Override
	public boolean isRequired()
	{
		return required;
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return true;
	}

	private final boolean required;
}
