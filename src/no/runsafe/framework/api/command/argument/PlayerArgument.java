package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

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
	public List<String> getAlternatives(RunsafePlayer executor, String partial)
	{
		return RunsafeServer.Instance.getOnlinePlayers(executor, partial);
	}

	private final boolean required;
}
