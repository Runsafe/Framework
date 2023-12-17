package no.runsafe.framework.api.command.argument;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class BooleanArgument extends CommandArgumentSpecification<Boolean> implements ITabComplete, IValueExpander
{
	public BooleanArgument(String name)
	{
		super(name);
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}

	@Override
	public Boolean getValue(IPlayer context, Map<String, String> params)
	{
		String value = params.get(name);
		if (value == null || value.isEmpty())
			return defaultValue;
		return value.startsWith("t");
	}

	@Override
	public List<String> getAlternatives(IPlayer executor, String partial)
	{
		return Lists.newArrayList("true", "false");
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, @Nullable String value)
	{
		if (value != null)
		{
			if (value.startsWith("t"))
				return "true";
			if (value.startsWith("f"))
				return "false";
		}
		return null;
	}
}
