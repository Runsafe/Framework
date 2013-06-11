package no.runsafe.framework.api.command;

import no.runsafe.framework.internal.command.prepared.PreparedAsynchronousCallbackCommand;
import no.runsafe.framework.api.IScheduler;

import java.util.HashMap;

/**
 * Base class representing a command that has an implementation that can be executed asynchronously with a return value
 * WARNING: Do not call bukkit APIs from the background thread!
 */
public abstract class AsyncCallbackCommand<T> extends ExecutableCommand
{
	public AsyncCallbackCommand(String name, String description, String permission, IScheduler scheduler, String... args)
	{
		super(name, description, permission, args);
		this.scheduler = scheduler;
	}

	/**
	 * Called on the main thread before {@link AsyncCallbackCommand#OnAsyncExecute(no.runsafe.framework.api.command.ICommandExecutor, java.util.HashMap)}
	 *
	 * @param executor   The player or console executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @param arguments  Tailing arguments not asked for in the command definition
	 * @return Message to show to the user running the command
	 */
	@Override
	public String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		return null;
	}

	/**
	 * Override this method if you have optional arguments
	 *
	 * @param executor   The player or console executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @param arguments  Tailing arguments not asked for in the command definition
	 * @return Data object that gets passed to SyncPostExecute
	 */
	public T OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		return OnAsyncExecute(executor, parameters);
	}

	/**
	 * If you have optional arguments, you still need to override this method but you can leave it empty.
	 *
	 * @param executor   The player or console executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Data object that gets passed to SyncPostExecute
	 */
	public abstract T OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters);

	/**
	 * This method gets called on the main thread after the {@link AsyncCallbackCommand#OnAsyncExecute(no.runsafe.framework.api.command.ICommandExecutor, java.util.HashMap)} completes
	 *
	 * @param result The value returned from the background thread
	 */
	public abstract void SyncPostExecute(T result);

	/**
	 * Callback from the prepared command object to use our scheduler
	 *
	 * @param target The prepared command that should get executed
	 */
	public final void Schedule(PreparedAsynchronousCallbackCommand target)
	{
		target.Schedule(scheduler);
	}

	private final IScheduler scheduler;
}
