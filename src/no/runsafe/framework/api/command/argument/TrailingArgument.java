package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public class TrailingArgument extends CommandArgumentSpecification<String>
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

	@Override
	public String getValue(IPlayer context, Map<String, String> params)
	{
		String param = params.get(name);
		if (param != null && !param.isEmpty())
			return param;
		return defaultValue;
	}
}
