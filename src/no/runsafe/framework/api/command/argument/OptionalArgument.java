package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;
import java.util.Map;

public class OptionalArgument extends CommandArgumentSpecification<String>
{
	public OptionalArgument(String name)
	{
		super(name);
	}

	@Deprecated
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

	@Override
	public String getValue(IPlayer context, Map<String, String> params)
	{
		String value = params.get(name);
		if (value != null && !value.isEmpty())
			return value;
		return defaultValue;
	}
}
