package no.runsafe.framework.internal.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.CommandArgumentSpecification;
import no.runsafe.framework.api.command.argument.ListOf;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.Player;

import javax.annotation.Nullable;
import java.util.List;

public abstract class BasePlayerArgument extends CommandArgumentSpecification<IPlayer> implements ListOf.Compatible<IPlayer>
{
	protected BasePlayerArgument(String name)
	{
		super(name);
		expand = false;
	}

	protected BasePlayerArgument(String name, boolean context)
	{
		super(name);
		expand = context;
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

	protected boolean expand;
}
