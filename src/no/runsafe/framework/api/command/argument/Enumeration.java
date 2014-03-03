package no.runsafe.framework.api.command.argument;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;
import java.lang.Enum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enumeration extends CommandArgumentSpecification<Enum<?>> implements ListOf.Compatible<Enum<?>>
{
	public Enumeration(String name, Enum<?>... values)
	{
		super(name);
		List<String> names = new ArrayList<String>(values.length);
		for (Enum<?> value : values)
		{
			this.values.put(value.name(), value);
			names.add(value.name());
		}
		alternatives = ImmutableList.copyOf(names);
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}

	@Override
	public List<String> getAlternatives(IPlayer executor, String partial)
	{
		//noinspection ReturnOfCollectionOrArrayField
		return alternatives;
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, @Nullable String value)
	{
		if (value == null)
			return null;
		for (String alternative : alternatives)
			if (alternative.toLowerCase().startsWith(value.toLowerCase()))
				return alternative;

		return null;
	}

	@Nullable
	@Override
	public Enum<?> getValue(IPlayer context, Map<String, String> params)
	{
		if (values.containsKey(params.get(name)))
			return values.get(params.get(name));

		return defaultValue;
	}

	private final ImmutableList<String> alternatives;
	private final Map<String, Enum<?>> values = new HashMap<String, Enum<?>>(0);
}
