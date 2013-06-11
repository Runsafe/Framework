package no.runsafe.framework.api.command.console;

import no.runsafe.framework.internal.command.AsyncCallbackCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.minecraft.RunsafeConsole;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.framework.api.IScheduler;

import java.util.HashMap;

/**
 * Base class representing a command that can only be executed by the console and has an implementation that can be executed asynchronously with a return value
 * WARNING: Do not call bukkit APIs from the background thread!
 */
public abstract class ConsoleAsyncCallbackCommand<T> extends AsyncCallbackCommand<T>
{
	public ConsoleAsyncCallbackCommand(String name, String description, IScheduler scheduler, String... args)
	{
		super(name, description, null, scheduler, args);
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafePlayer)
			return "This command must be used from the console.";
		return OnExecute(parameters, arguments);
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters)
	{
		return null;
	}

	@Override
	public final T OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafeConsole)
			return OnAsyncExecute(parameters, arguments);
		return null;
	}

	@Override
	public final T OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters)
	{
		if (executor instanceof RunsafeConsole)
			return OnAsyncExecute(parameters);
		return null;
	}

	/**
	 * This method is called on the main thread before {@link ConsoleAsyncCallbackCommand#OnAsyncExecute(java.util.HashMap)}
	 * Override this method if you use optional arguments
	 *
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @param arguments  Tailing arguments not asked for in the command definition
	 * @return Message to show in the console
	 */
	public String OnExecute(HashMap<String, String> parameters, String[] arguments)
	{
		return OnExecute(parameters);
	}

	/**
	 * This method is called on the main thread before {@link ConsoleAsyncCallbackCommand#OnAsyncExecute(java.util.HashMap)}
	 * Override this method if you don't use optional arguments
	 *
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show in the console
	 */
	public String OnExecute(HashMap<String, String> parameters)
	{
		return null;
	}

	/**
	 * If you use optional arguments, override this method
	 *
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @param arguments  Tailing arguments not asked for in the command definition
	 * @return A value to return to the post-processing method
	 */
	public T OnAsyncExecute(HashMap<String, String> parameters, String[] arguments)
	{
		return OnAsyncExecute(parameters);
	}

	/**
	 * If you use optional arguments, you still need to override this but you can leave it empty.
	 *
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return A value to return to the post-processing method
	 */
	public abstract T OnAsyncExecute(HashMap<String, String> parameters);
}
