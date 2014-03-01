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
	@Deprecated
	public static class Required extends EntityType
	{
		public Required()
		{
			super("entityType");
		}

		public Required(String name)
		{
			super(name);
		}

		@Override
		public boolean isRequired()
		{
			return true;
		}
	}

	@Deprecated
	public static class Optional extends EntityType
	{
		public Optional()
		{
			super("entityType");
		}

		public Optional(String name)
		{
			super(name);
		}

		@Override
		public boolean isRequired()
		{
			return false;
		}
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
		List<String> alternates = new ArrayList<String>(org.bukkit.entity.EntityType.values().length);
		for (org.bukkit.entity.EntityType type : org.bukkit.entity.EntityType.values())
		{
			if (filter == null)
				alternates.add(type.name());
			else
			{
				String name = type.name().toLowerCase();
				if (name.equals(filter) || name.startsWith(filter))
					alternates.add(type.name());
			}
		}
		return alternates;
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, @Nullable String value)
	{
		if (value == null)
			return null;
		String filter = value.toLowerCase();
		for (org.bukkit.entity.EntityType type : org.bukkit.entity.EntityType.values())
		{
			String name = type.name().toLowerCase();
			if (name.equals(filter) || name.startsWith(filter))
				return type.name();
		}
		return null;
	}

	@Override
	public RunsafeEntityType getValue(IPlayer context, Map<String, String> params)
	{
		String param = params.get(name);
		RunsafeEntityType value = null;
		if (param != null && !param.isEmpty())
			value = no.runsafe.framework.minecraft.entity.EntityType.Get(param);
		return value == null ? defaultValue : null;
	}
}
