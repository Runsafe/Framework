package no.runsafe.framework.api.command;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.internal.command.PreparedAsynchronousCallbackCommand;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Base class representing a command that has an implementation that can be executed asynchronously with a return value
 * WARNING: Do not call bukkit APIs from the background thread!
 */
public abstract class AsyncCallbackCommand<T> extends ExecutableCommand implements CommandScheduler, IAsyncCallbackExecute<T>
{
	protected AsyncCallbackCommand(String name, String description, String permission, IScheduler scheduler, CharSequence... args)
	{
		super(name, description, permission, args);
		this.scheduler = scheduler;
	}

	/**
	 * Called on the main thread before {@link AsyncCallbackCommand#OnAsyncExecute(ICommandExecutor, HashMap)}
	 *
	 * @param executor   The player or console executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @param arguments  Tailing arguments not asked for in the command definition
	 * @return Message to show to the user running the command
	 */
	@Nullable
	@Override
	@Deprecated
	public String OnExecute(ICommandExecutor executor, Map<String, String> parameters, String... arguments)
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
	@Override
	@Deprecated
	public T OnAsyncExecute(ICommandExecutor executor, Map<String, String> parameters, String... arguments)
	{
		return OnAsyncExecute(executor, parameters);
	}

	@Nonnull
	@Override
	public IScheduler getScheduler()
	{
		return scheduler;
	}

	@Nonnull
	@Override
	public IPreparedCommand createAction(
		@Nonnull ICommandExecutor executor,
		@Nonnull Stack<ICommandHandler> stack,
		@Nonnull String[] args,
		@Nonnull Map<String, String> params
	)
	{
		console.finer("Preparing AsyncCallback command with %d params and %d args", params.size(), args.length);
		return new PreparedAsynchronousCallbackCommand(executor, stack, args, params);
	}

	private final IScheduler scheduler;
}
