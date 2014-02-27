package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.minecraft.IEnchant;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Enchant extends CommandArgumentSpecification implements ListOf.Compatible<IEnchant>
{
	public static class Required extends Enchant
	{
		public Required()
		{
			super("enchant");
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

	public static class Optional extends Enchant
	{
		public Optional()
		{
			super("enchant");
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

	protected Enchant(String name)
	{
		super(name);
		required = false;
	}

	@Deprecated
	public Enchant(boolean required)
	{
		this("enchant", required);
	}

	@Deprecated
	public Enchant(String name, boolean required)
	{
		super(name);
		this.required = required;
	}

	@Override
	public List<String> getAlternatives(IPlayer executor, String partial)
	{
		String filter = partial == null ? null : partial.toLowerCase();
		List<String> alternates = new ArrayList<String>(no.runsafe.framework.minecraft.Enchant.All.size());
		for (IEnchant enchant : no.runsafe.framework.minecraft.Enchant.All)
		{
			if (filter == null)
				alternates.add(enchant.getName());
			else
			{
				String name = enchant.getName().toLowerCase();
				if (name.equals(filter) || name.startsWith(filter))
					alternates.add(enchant.getName());
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
		for (IEnchant enchant : no.runsafe.framework.minecraft.Enchant.All)
		{
			String name = enchant.getName().toLowerCase();
			if (name.equals(filter) || name.startsWith(filter))
				return enchant.getName();
		}
		return null;
	}

	@Override
	public IEnchant getValue(IPlayer context, Map<String, String> params)
	{
		return no.runsafe.framework.minecraft.Enchant.getByName(params.get(name));
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

	private final boolean required;
}
