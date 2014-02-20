package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.hook.IPlayerExtensions;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class UserGroupArgument extends CommandArgumentSpecification implements ListOf.Compatible
{
	public UserGroupArgument(String name, boolean required)
	{
		super(name);
		isRequired = required;
	}

	@Override
	public boolean isRequired()
	{
		return isRequired;
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return false;
	}

	@Override
	public List<String> getAlternatives(IPlayer executor, String partial)
	{
		List<String> options = InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).getGroups();
		if (partial == null || partial.isEmpty())
			return options;

		String match = partial.toLowerCase();
		List<String> candidates = new ArrayList<String>(options.size());
		for (String option : options)
			if (option.toLowerCase().startsWith(match))
				candidates.add(option);

		return candidates;
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, @Nullable String value)
	{
		List<String> alternatives = getAlternatives((IPlayer) context, value);
		return alternatives.isEmpty() || alternatives.size() > 1 ? null : alternatives.get(0);
	}

	private final boolean isRequired;
}
