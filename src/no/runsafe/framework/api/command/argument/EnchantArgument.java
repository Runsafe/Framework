package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.minecraft.IEnchant;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Enchant;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class EnchantArgument extends CommandArgumentSpecification implements ListOf.Compatible
{
	public EnchantArgument(boolean required)
	{
		this("enchant", required);
	}

	public EnchantArgument(String name, boolean required)
	{
		super(name);
		this.required = required;
	}

	@Override
	public List<String> getAlternatives(IPlayer executor, String partial)
	{
		String filter = partial == null ? null : partial.toLowerCase();
		List<String> alternates = new ArrayList<String>(Enchant.All.size());
		for (IEnchant enchant : Enchant.All)
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
		for (IEnchant enchant : Enchant.All)
		{
			String name = enchant.getName().toLowerCase();
			if (name.equals(filter) || name.startsWith(filter))
				return enchant.getName();
		}
		return null;
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
