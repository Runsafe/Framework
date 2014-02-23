package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public class IntegerArgument extends CommandArgumentSpecification implements IValueProvider<Integer>
{
	public IntegerArgument(String name, boolean required)
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
		return false;
	}

	@Override
	public Integer getValue(IPlayer context, Map<String, String> params)
	{
		try
		{
			return Integer.parseInt(params.get(name));
		}
		catch (NumberFormatException e)
		{
			return null;
		}
	}

	private final boolean required;
}
