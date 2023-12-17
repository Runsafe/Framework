package no.runsafe.framework.api.command.argument;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.player.IPlayer;

import java.util.List;

public class StaticArgument extends RequiredArgument implements ITabComplete
{
	public StaticArgument(String flag)
	{
		super(flag);
	}

	@Override
	public List<String> getAlternatives(IPlayer executor, String partial)
	{
		return Lists.newArrayList(name);
	}
}
