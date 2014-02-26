package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public class FloatArgument extends CommandArgumentSpecification implements IValueProvider<Float>
{
	public class Required extends FloatArgument
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

	public class Optional extends FloatArgument
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

	protected FloatArgument(String name)
	{
		super(name);
		required = false;
	}

	@Deprecated
	public FloatArgument(String name, boolean required)
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
	public Float getValue(IPlayer context, Map<String, String> params)
	{
		try
		{
			return Float.parseFloat(params.get(name));
		}
		catch (NumberFormatException e)
		{
			return null;
		}
	}

	private final boolean required;
}
