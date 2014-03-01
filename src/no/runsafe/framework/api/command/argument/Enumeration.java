package no.runsafe.framework.api.command.argument;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Enumeration extends CommandArgumentSpecification<Enum<?>> implements ListOf.Compatible<Enum<?>>
{
	@Deprecated
	public static class Required extends Enumeration
	{
		public Required(String name, java.lang.Enum<?>[] values)
		{
			super(name, values, null);
		}

		@Deprecated
		public Required(String name, java.lang.Enum<?>[] values, java.lang.Enum<?> defaultValue)
		{
			super(name, values, defaultValue);
		}

		@Override
		public boolean isRequired()
		{
			return true;
		}
	}

	@Deprecated
	public static class Optional extends Enumeration
	{
		public Optional(String name, java.lang.Enum<?>[] values)
		{
			super(name, values, null);
		}

		@Deprecated
		public Optional(String name, java.lang.Enum<?>[] values, java.lang.Enum<?> defaultValue)
		{
			super(name, values, defaultValue);
		}

		@Override
		public boolean isRequired()
		{
			return false;
		}
	}

	protected Enumeration(String name, java.lang.Enum<?>[] values, java.lang.Enum<?> defaultValue)
	{
		super(name);
		List<String> names = new ArrayList<String>(values.length);
		for (java.lang.Enum<?> value : values)
		{
			this.values.put(value.name(), value);
			names.add(value.name());
		}
		alternatives = ImmutableList.copyOf(names);
		this.defaultValue = defaultValue;
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
	private final Map<String, java.lang.Enum<?>> values = new HashMap<String, java.lang.Enum<?>>(0);
}
