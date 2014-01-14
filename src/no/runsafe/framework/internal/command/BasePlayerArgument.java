package no.runsafe.framework.internal.command;

import no.runsafe.framework.api.command.argument.CommandArgumentSpecification;
import no.runsafe.framework.api.command.argument.ITabComplete;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.Player;

import java.util.List;

public abstract class BasePlayerArgument extends CommandArgumentSpecification implements ITabComplete
{
	public BasePlayerArgument(String name, boolean required)
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
		return Player.Get().getOnline(executor, partial);
	}

	protected final boolean required;
}
