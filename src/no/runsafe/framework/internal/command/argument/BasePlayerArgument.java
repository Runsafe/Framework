package no.runsafe.framework.internal.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.CommandArgumentSpecification;
import no.runsafe.framework.api.command.argument.ITabComplete;
import no.runsafe.framework.api.command.argument.IValueExpander;
import no.runsafe.framework.api.command.argument.ListOf;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.Player;

import javax.annotation.Nullable;
import java.util.List;

public abstract class BasePlayerArgument extends CommandArgumentSpecification implements ListOf.Compatible
{
	protected BasePlayerArgument(String name, boolean required, boolean context)
	{
		super(name);
		this.required = required;
		expand = context;
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
		return Player.Get().getOnline(executor, partial);
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, @Nullable String value)
	{
		if(expand && value == null)
			return context.getName();

		return null;
	}

	protected final boolean required;
	protected final boolean expand;
}
