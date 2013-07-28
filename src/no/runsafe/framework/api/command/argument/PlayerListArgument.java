package no.runsafe.framework.api.command.argument;

public class PlayerListArgument extends PlayerArgument
{
	public PlayerListArgument(boolean required)
	{
		super("players", required);
	}

	@Override
	public boolean isWhitespaceInclusive()
	{
		return true;
	}
}
