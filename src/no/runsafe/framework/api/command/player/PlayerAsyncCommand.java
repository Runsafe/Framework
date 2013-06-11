package no.runsafe.framework.api.command.player;

import no.runsafe.framework.internal.command.AsyncCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.framework.api.IScheduler;

import java.util.HashMap;

/**
 * Base class representing a command that can only be executed by a player and has an implementation that can be executed asynchronously
 * WARNING: Do not call bukkit APIs from the background thread!
 */
public abstract class PlayerAsyncCommand extends AsyncCommand
{
	public PlayerAsyncCommand(String name, String description, String permission, IScheduler scheduler, String... args)
	{
		super(name, description, permission, scheduler, args);
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafePlayer)
			return OnExecute((RunsafePlayer) executor, parameters, arguments);
		return "This command cannot be used from the console.";
	}

	@Override
	public final String OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafePlayer)
			return OnAsyncExecute((RunsafePlayer) executor, parameters, arguments);
		return "This command cannot be used from the console.";
	}

	@Override
	public final String OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters)
	{
		if (executor instanceof RunsafePlayer)
			return OnAsyncExecute((RunsafePlayer) executor, parameters);
		return "This command cannot be used from the console.";
	}

	/**
	 * This method is called on the main thread before {@link PlayerAsyncCommand#OnAsyncExecute(no.runsafe.framework.api.command.ICommandExecutor, java.util.HashMap)}
	 * Override this method if you use optional arguments
	 *
	 * @param executor   The player executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @param arguments  Tailing arguments not asked for in the command definition
	 * @return Message to show to the user running the command
	 */
	public String OnExecute(RunsafePlayer executor, HashMap<String, String> parameters, String[] arguments)
	{
		return OnExecute(executor, parameters);
	}

	/**
	 * This method is called on the main thread before {@link PlayerAsyncCommand#OnAsyncExecute(no.runsafe.framework.api.command.ICommandExecutor, java.util.HashMap)}
	 * Override this method if you don't use optional arguments
	 *
	 * @param executor   The player executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show to the user running the command
	 */
	public String OnExecute(RunsafePlayer executor, HashMap<String, String> parameters)
	{
		return null;
	}

	/**
	 * If you use optional arguments, override this method
	 *
	 * @param executor   The player executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @param arguments  Tailing arguments not asked for in the command definition
	 * @return Message to show to the user running the command after the command completes
	 */
	public String OnAsyncExecute(RunsafePlayer executor, HashMap<String, String> parameters, String[] arguments)
	{
		return OnAsyncExecute(executor, parameters);
	}

	/**
	 * If you use optional arguments, you still need to override this but you can leave it empty.
	 *
	 * @param executor   The player executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show to the user running the command after the command completes
	 */
	public abstract String OnAsyncExecute(RunsafePlayer executor, HashMap<String, String> parameters);
}
