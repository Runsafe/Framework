package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.command.BasePlayerArgument;

import java.util.Map;

// This is going abstract.
@Deprecated
public class PlayerArgument extends BasePlayerArgument
{
	public PlayerArgument()
	{
		this(true);
	}

	public PlayerArgument(boolean required)
	{
		super("player", required);
	}

	public PlayerArgument(String name, boolean required)
	{
		super(name, required);
	}

	// TODO Make abstract
	public IPlayer getValue(IPlayer context, Map<String, String> params)
	{
		return InjectionPlugin.getGlobalComponent(IServer.class).getPlayer(params.get(name));
	}
}
