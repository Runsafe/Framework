package no.runsafe.framework.api.command.player;

import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.Map;

/**
 * Base class representing a command that can only be executed by a player
 */
public abstract class PlayerCommand extends ExecutableCommand
{
	public PlayerCommand(String commandName, String description, String permission, String... arguments)
	{
		super(commandName, description, permission, arguments);
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, Map<String, String> parameters, String... arguments)
	{
		if (executor instanceof RunsafePlayer)
			return OnExecute((RunsafePlayer) executor, parameters, arguments);

		return "This command cannot be used from the console.";
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, Map<String, String> parameters)
	{
		if (executor instanceof RunsafePlayer)
			return OnExecute((RunsafePlayer) executor, parameters);

		return "This command cannot be used from the console.";
	}

	/**
	 * Override this method if you use optional arguments
	 *
	 * @param executor   The player executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @param arguments  Tailing arguments not asked for in the command definition
	 * @return Message to show to the user running the command
	 */
	public String OnExecute(RunsafePlayer executor, Map<String, String> parameters, String... arguments)
	{
		return OnExecute(executor, parameters);
	}

	/**
	 * If you use optional arguments, you must still override this command but you can leave it blank.
	 *
	 * @param executor   The player executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show to the user running the command
	 */
	public abstract String OnExecute(RunsafePlayer executor, Map<String, String> parameters);
}
