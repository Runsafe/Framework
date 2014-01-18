package no.runsafe.framework.internal.command;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.CommandArgumentSpecification;
import no.runsafe.framework.api.command.argument.ITabComplete;
import no.runsafe.framework.api.command.argument.IValueExpander;
import no.runsafe.framework.api.command.argument.IValueProvider;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class MapArgument<T> extends CommandArgumentSpecification implements ITabComplete, IValueExpander, IValueProvider<T>
{
	protected MapArgument(String name, Map<String, T> values)
	{
		super(name);
		alternatives = Collections.unmodifiableMap(values);
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}

	@Override
	public List<String> getAlternatives(IPlayer executor, String partial)
	{
		return Lists.newArrayList(alternatives.keySet());
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, @Nullable String value)
	{
		if (value == null)
			return null;

		for (String key : alternatives.keySet())
			if (key.equalsIgnoreCase(value) || key.toLowerCase().startsWith(value.toLowerCase()))
				return key;

		return null;
	}

	@Override
	public T getValue(IPlayer context, Map<String, String> params)
	{
		return alternatives.get(params.get(name));
	}

	private final Map<String, T> alternatives;
}
