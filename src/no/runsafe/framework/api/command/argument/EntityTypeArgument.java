package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;
import org.bukkit.entity.EntityType;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class EntityTypeArgument extends CommandArgumentSpecification implements ListOf.Compatible
{
	public class Required extends EntityTypeArgument
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

	public class Optional extends EntityTypeArgument
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

	protected EntityTypeArgument(String name)
	{
		super(name);
		required = false;
	}

	@Deprecated
	public EntityTypeArgument(boolean required)
	{
		this("entityType", required);
	}

	@Deprecated
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
		for (EntityType type : EntityType.values())
		{
			String name = type.name().toLowerCase();
			if (name.equals(filter) || name.startsWith(filter))
				return type.name();
		}
		return null;
	}

	private final boolean required;
}
