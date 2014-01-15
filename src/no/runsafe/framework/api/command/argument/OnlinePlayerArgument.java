package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.Player;
import no.runsafe.framework.internal.extension.player.RunsafeAmbiguousPlayer;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class OnlinePlayerArgument extends PlayerArgument implements IValueExpander
{
	public OnlinePlayerArgument()
	{
	}

	public OnlinePlayerArgument(boolean required)
	{
		super(required);
	}

	public OnlinePlayerArgument(boolean required, boolean context)
	{
		super(required, context);
	}

	public OnlinePlayerArgument(String name, boolean required)
	{
		super(name, required);
	}

	public OnlinePlayerArgument(String name, boolean required, boolean context)
	{
		super(name, required, context);
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, String value)
	{
		if (context instanceof IPlayer)
		{
			List<String> matches = Player.Get().getOnline((IPlayer) context, value);
			if (matches.size() > 1)
				context.sendColouredMessage(new RunsafeAmbiguousPlayer(null, matches).toString());
			if (matches != null && matches.size() == 1)
				return matches.get(0);
		}
		else
		{
			List<String> matches = Player.Get().getOnline(value);
			if (matches.size() > 1)
				context.sendColouredMessage(new RunsafeAmbiguousPlayer(null, matches).toString());
			if (matches != null && matches.size() == 1)
				return matches.get(0);
		}
		return isRequired() ? Invalid : value;
	}

	public IPlayer getValue(IPlayer context, Map<String, String> params)
	{
		return InjectionPlugin.getGlobalComponent(IServer.class).getOnlinePlayer(context, params.get(name));
	}

	public static final String Invalid = "\0INVALID\0";
}
