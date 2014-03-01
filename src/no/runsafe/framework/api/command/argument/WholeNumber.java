package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public class WholeNumber extends CommandArgumentSpecification<Integer>
{
	@Deprecated
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

	@Deprecated
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

	public WholeNumber(String name)
	{
		super(name);
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}

	public WholeNumber withDefault(int value)
	{
		defaultValue = value;
		return this;
	}

	@Override
	public Integer getValue(IPlayer context, Map<String, String> params)
	{
		try
		{
			if (params.get(name) == null || params.get(name).isEmpty())
				return defaultValue;
			return Integer.parseInt(params.get(name));
		}
		catch (NumberFormatException e)
		{
			return defaultValue;
		}
	}

	private Integer defaultValue = null;
}
