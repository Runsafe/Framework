package no.runsafe.framework.api.command.player;

import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgument;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;

/**
 * Base class representing a command that can only be executed by a player
 */
public abstract class PlayerCommand extends ExecutableCommand implements IPlayerExecute
{
	protected PlayerCommand(String commandName, String description, String permission, IArgument... arguments)
	{
		super(commandName, description, permission, arguments);
	}

	@SuppressWarnings("InstanceofInterfaces")
	@Override
	public final String OnExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		if (executor instanceof RunsafePlayer)
			return OnExecute((IPlayer) executor, parameters);

		return "This command cannot be used from the console.";
	}
}
