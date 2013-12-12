package no.runsafe.framework.api.command.argument;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class EnumArgument extends CommandArgumentSpecification implements ITabComplete, IValueExpander
{
	public EnumArgument(String name, Enum<?>[] values, boolean required)
	{
		super(name);
		List<String> names = new ArrayList<String>(values.length);
		for (Enum<?> value : values)
			names.add(value.name());
		alternatives = ImmutableList.copyOf(names);
		this.required = required;
	}

	public EnumArgument(String name, Iterable<String> values, boolean required)
	{
		super(name);
		alternatives = ImmutableList.copyOf(values);
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
	public List<String> getAlternatives(IPlayer executor, String partial)
	{
		//noinspection ReturnOfCollectionOrArrayField
		return alternatives;
	}

	@Nullable
	@Override
	public String expand(String value)
	{
		for (String alternative : alternatives)
			if (alternative.toLowerCase().startsWith(value.toLowerCase()))
				return alternative;

		return null;
	}

	private final boolean required;
	private final ImmutableList<String> alternatives;
}
