package no.runsafe.framework.api.command;

import no.runsafe.framework.internal.command.prepared.PreparedAsynchronousCommand;
import no.runsafe.framework.api.IScheduler;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Base class representing a command that has an implementation that can be executed asynchronously
 * WARNING: Do not call bukkit APIs from the background thread!
 */
public abstract class AsyncCommand extends ExecutableCommand
{
	protected AsyncCommand(String name, String description, String permission, IScheduler scheduler, String... args)
	{
		super(name, description, permission, args);
		this.scheduler = scheduler;
	}

	@Nullable
	@Override
	public String OnExecute(ICommandExecutor executor, Map<String, String> parameters)
	{
		return null;
	}

	/**
	 * If you use optional arguments, override this method
	 *
	 * @param executor   The console or player executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @param arguments  Tailing arguments not asked for in the command definition
	 * @return Message to show to the user running the command
	 */
	public String OnAsyncExecute(ICommandExecutor executor, Map<String, String> parameters, String... arguments)
	{
		return OnAsyncExecute(executor, parameters);
	}

	/**
	 * If you use optional arguments, you still need to override this but you can leave it empty.
	 *
	 * @param executor   The console or player executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show to the user running the command
	 */
	public abstract String OnAsyncExecute(ICommandExecutor executor, Map<String, String> parameters);

	/**
	 * Callback from the prepared command object to use our scheduler
	 *
	 * @param target The prepared command that should get executed
	 */
	public final void Schedule(PreparedAsynchronousCommand target)
	{
		target.schedule(scheduler);
	}

	private final IScheduler scheduler;
}
