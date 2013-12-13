package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.player.RunsafeAmbiguousPlayer;

import javax.annotation.Nullable;
import java.util.List;

public class AnyPlayerArgument extends PlayerArgument implements IValueExpander
{
	public AnyPlayerArgument()
	{
	}

	public AnyPlayerArgument(boolean required)
	{
		super(required);
	}

	public AnyPlayerArgument(String name, boolean required)
	{
		super(name, required);
	}

	@Nullable
	@Override
	public String expand(ICommandExecutor context, String value)
	{
		List<String> matches = RunsafeServer.findPlayer(value);
		if (matches.size() > 1)
			context.sendColouredMessage(new RunsafeAmbiguousPlayer(null, matches).toString());
		if (matches.size() == 1)
			return matches.get(0);
		return isRequired() ? Invalid : value;
	}

	public static final String Invalid = "\0INVALID\0";
}
