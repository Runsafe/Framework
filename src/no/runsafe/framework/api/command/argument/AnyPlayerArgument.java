package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.internal.extension.RunsafeServer;
import no.runsafe.framework.internal.extension.player.RunsafeAmbiguousPlayer;

import javax.annotation.Nullable;
import java.util.List;
import java.util.regex.Matcher;

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
		if (value == null)
			return super.expand(context, null);

		Matcher quoted = QUOTED_NAME.matcher(value);
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
		return isRequired() ? Invalid : value;
	}

	public static final String Invalid = "\0INVALID\0";
}
