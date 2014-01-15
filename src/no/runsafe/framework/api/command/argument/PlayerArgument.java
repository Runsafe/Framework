package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.Player;
import no.runsafe.framework.internal.command.BasePlayerArgument;
import no.runsafe.framework.minecraft.Sound;

import java.util.Map;

// This is going abstract.
@Deprecated
public class PlayerArgument extends BasePlayerArgument
{
	public PlayerArgument()
	{
		this(true, false);
	}

	public PlayerArgument(boolean required)
	{
		this(required, false);
	}

	public PlayerArgument(boolean required, boolean context)
	{
		super("player", required, context);
	}

	public PlayerArgument(String name, boolean required)
	{
		this(name, required, false);
	}

	public PlayerArgument(String name, boolean required, boolean context)
	{
		super(name, required, context);
	}

	// TODO Make abstract
	public IPlayer getValue(IPlayer context, Map<String, String> params)
	{
		return InjectionPlugin.getGlobalComponent(IServer.class).getPlayer(params.get(name));
	}
}
