package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public abstract class DecimalNumber extends CommandArgumentSpecification implements IValueProvider<java.lang.Float>
{
	public static class Required extends DecimalNumber
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

	public static class Optional extends DecimalNumber
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

	protected DecimalNumber(String name)
	{
		super(name);
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}

	@Override
	public java.lang.Float getValue(IPlayer context, Map<String, String> params)
	{
		try
		{
			return java.lang.Float.parseFloat(params.get(name));
		}
		catch (NumberFormatException e)
		{
			return null;
		}
	}
}