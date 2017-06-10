package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public abstract class StringArgumentSpecification extends CommandArgumentSpecification<String>
{
	protected StringArgumentSpecification(String name)
	{
		super(name);
	}

	@Override
	public String getValue(IPlayer context, Map<String, String> params)
	{
		String value = params.get(name);
		if (value != null && !value.isEmpty())
			return applyChanges(value);
		return applyChanges(defaultValue);
	}

	/**
	 * Makes the output uppercase.
	 * If both upper and lower are set, uppercase should take priority.
	 */
	public StringArgumentSpecification toUppercase()
	{
		upperCase = true;
		return this;
	}

	/**
	 * Makes the output lowercase.
	 * If both upper and lower are set, uppercase should take priority.
	 */
	public StringArgumentSpecification toLowercase()
	{
		lowerCase = true;
		return this;
	}

	/**
	 * Applies upper or lower case changes if needed.
	 * @param value Argument to change.
	 * @return Altered value.
	 */
	private String applyChanges(String value)
	{
		if (upperCase)
			return value.toUpperCase();
		if (lowerCase)
			return value.toLowerCase();

		return value;
	}

	private boolean upperCase = false;
	private boolean lowerCase = false;
}
