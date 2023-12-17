package no.runsafe.framework.api.command;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.command.argument.IArgument;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.internal.command.PreparedAsynchronousCallbackCommand;

import javax.annotation.Nonnull;
import java.util.Stack;

/**
 * Base class representing a command that has an implementation that can be executed asynchronously with a return value
 * WARNING: Do not call bukkit APIs from the background thread!
 */
public abstract class AsyncCallbackCommand<T> extends ExecutableCommand implements CommandScheduler, IAsyncCallbackExecute<T>
{
	protected AsyncCallbackCommand(String name, String description, String permission, IScheduler scheduler, IArgument... args)
	{
		super(name, description, permission, args);
		this.scheduler = scheduler;
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
		@Nonnull IArgumentList params
	)
	{
		console.debugFiner("Preparing AsyncCallback command with %d params and %d args", params.size(), args.length);
		return new PreparedAsynchronousCallbackCommand(executor, stack, args, params);
	}

	private final IScheduler scheduler;
}
