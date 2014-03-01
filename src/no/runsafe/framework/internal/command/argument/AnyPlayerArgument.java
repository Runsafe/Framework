package no.runsafe.framework.internal.command.argument;

import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.command.Command;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IValueProvider;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.extension.RunsafeServer;
import no.runsafe.framework.internal.extension.player.RunsafeAmbiguousPlayer;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

public abstract class AnyPlayerArgument extends BasePlayerArgument
{
	protected AnyPlayerArgument(boolean required, boolean context)
	{
		this("player", required, context);
	}

	protected AnyPlayerArgument(String name, boolean required, boolean context)
	{
		super(name, required, context);
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, @Nullable String value)
	{
		if (value == null)
			return super.expand(context, null);

		Matcher quoted = Command.QUOTED_ARGUMENT.matcher(value);
		if (quoted.matches())
			return quoted.group(1);

		List<String> matches = RunsafeServer.findPlayer(value);
		if (matches.size() > 1)
		{
			context.sendColouredMessage(new RunsafeAmbiguousPlayer(null, matches).toString());
			if (!isRequired() && expand)
				return null;
		}
		if (matches.size() == 1)
			return matches.get(0);

		context.sendColouredMessage("Unable to locate any players matching '%s'!", value);
		return null;
	}

	@Override
	public IPlayer getValue(IPlayer context, Map<String, String> params)
	{
		return InjectionPlugin.getGlobalComponent(IServer.class).getPlayerExact(params.get(name));
	}
}
