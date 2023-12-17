package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EntityType extends CommandArgumentSpecification<RunsafeEntityType> implements ListOf.Compatible<RunsafeEntityType>
{
	public EntityType()
	{
		super("entityType");
	}

	public EntityType(String name)
	{
		super(name);
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}

	@Override
	public List<String> getAlternatives(IPlayer executor, String partial)
	{
		String filter = partial == null ? null : partial.toLowerCase();
		List<String> alternates = new ArrayList<String>();

		for (RunsafeEntityType type : no.runsafe.framework.minecraft.entity.EntityType.getTypesByName(filter))
			alternates.add(type.getAPIName());

		return alternates;
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, @Nullable String value)
	{
		if (value == null)
			return null;

		List<RunsafeEntityType> types = no.runsafe.framework.minecraft.entity.EntityType.getTypesByName(value.toLowerCase());
		return types.isEmpty() ? null : types.get(0).getAPIName();
	}

	@Override
	public RunsafeEntityType getValue(IPlayer context, Map<String, String> params)
	{
		String param = params.get(name);
		RunsafeEntityType value = null;
		if (param != null && !param.isEmpty())
			value = no.runsafe.framework.minecraft.entity.EntityType.getTypeByName(param);
		return value == null ? defaultValue : value;
	}
}
