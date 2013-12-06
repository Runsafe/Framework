package no.runsafe.framework.api.command.player;

import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgument;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.Map;

/**
 * Base class representing a command that can only be executed by a player
 */
public abstract class PlayerCommand extends ExecutableCommand implements IPlayerExecute
{
	protected PlayerCommand(String commandName, String description, String permission, IArgument... arguments)
	{
		super(commandName, description, permission, arguments);
	}

	@SuppressWarnings({"CastToConcreteClass", "InstanceofInterfaces"})
	@Override
	public final String OnExecute(ICommandExecutor executor, Map<String, String> parameters)
	{
		if (executor instanceof RunsafePlayer)
			return OnExecute((RunsafePlayer) executor, parameters);

		return "This command cannot be used from the console.";
	}
}
