package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.extension.RunsafeServer;
import no.runsafe.framework.internal.extension.player.RunsafeAmbiguousPlayer;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class AnyPlayerArgument extends PlayerArgument
{
	public AnyPlayerArgument()
	{
	}

	public AnyPlayerArgument(boolean required)
	{
		super(required);
	}

	public AnyPlayerArgument(boolean required, boolean context)
	{
		super(required, context);
	}

	public AnyPlayerArgument(String name, boolean required)
	{
		super(name, required);
	}

	public AnyPlayerArgument(String name, boolean required, boolean context)
	{
		super(name, required, context);
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, @Nullable String value)
	{
		if (expand && value == null)
			return context.getName();

		List<String> matches = RunsafeServer.findPlayer(value);
		if (matches.size() > 1)
			context.sendColouredMessage(new RunsafeAmbiguousPlayer(null, matches).toString());
		if (matches.size() == 1)
			return matches.get(0);
		return isRequired() ? Invalid : value;
	}

	@Override
	public IPlayer getValue(IPlayer context, Map<String, String> params)
	{
		return InjectionPlugin.getGlobalComponent(IServer.class).getPlayer(params.get(name));
	}

	public static final String Invalid = "\0INVALID\0";
}
