package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public abstract class WholeNumber extends CommandArgumentSpecification implements IValueProvider<java.lang.Integer>
{
	public static class Required extends WholeNumber
	{
		public Required(String name)
		{
			super(name);
		}

		@Override
		public boolean isRequired()
		{
			return true;
		}
	}

	public static class Optional extends WholeNumber
	{
		public Optional(String name)
		{
			super(name);
		}

		@Override
		public boolean isRequired()
		{
			return false;
		}
	}

	protected WholeNumber(String name)
	{
		super(name);
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}

	@Override
	public java.lang.Integer getValue(IPlayer context, Map<String, String> params)
	{
		try
		{
			return java.lang.Integer.parseInt(params.get(name));
		}
		catch (NumberFormatException e)
		{
			return null;
		}
	}
}
