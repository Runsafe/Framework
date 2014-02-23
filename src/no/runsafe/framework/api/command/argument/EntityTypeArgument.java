package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;
import org.bukkit.entity.EntityType;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class EntityTypeArgument extends CommandArgumentSpecification implements ListOf.Compatible
{
	public EntityTypeArgument(boolean required)
	{
		this("entityType", required);
	}

	public EntityTypeArgument(String name, boolean required)
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
		return false;
	}

	@Override
	public List<String> getAlternatives(IPlayer executor, String partial)
	{
		String filter = partial == null ? null : partial.toLowerCase();
		List<String> alternates = new ArrayList<String>(org.bukkit.entity.EntityType.values().length);
		for (EntityType type : EntityType.values())
		{
			if (filter == null)
				alternates.add(type.name());
			else
			{
				String name = type.name();
				if (name.equals(filter) || name.startsWith(filter))
					alternates.add(name);
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
		for (EntityType type : EntityType.values())
		{
			String name = type.name().toLowerCase();
			if (name.equals(filter) || name.startsWith(filter))
				return name;
		}
		return null;
	}

	private final boolean required;
}
