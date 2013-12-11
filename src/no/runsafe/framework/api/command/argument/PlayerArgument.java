package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.Player;
import no.runsafe.framework.minecraft.RunsafeServer;

import java.util.List;

public class PlayerArgument extends CommandArgumentSpecification implements ITabComplete
{
	public PlayerArgument()
	{
		this(true);
	}

	public PlayerArgument(boolean required)
	{
		super("player");
		this.required = required;
	}

	public PlayerArgument(String name, boolean required)
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
		return Player.getOnline(executor, partial);
	}

	private final boolean required;
}
