package no.runsafe.framework.api.command.argument;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.ArrayList;
import java.util.List;

public class EnumArgument extends CommandArgumentSpecification implements ITabComplete
{
	protected EnumArgument(String name, Enum<?>[] values, boolean required)
	{
		super(name);
		List<String> names = new ArrayList<String>(values.length);
		for (Enum<?> value : values)
			names.add(value.name().toLowerCase());
		alternatives = ImmutableList.copyOf(names);
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
	public List<String> getAlternatives(RunsafePlayer executor, String partial)
	{
		//noinspection ReturnOfCollectionOrArrayField
		return alternatives;
	}

	private final boolean required;
	private final ImmutableList<String> alternatives;
}
