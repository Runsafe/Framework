package no.runsafe.framework.api.command.console;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.command.AsyncCallbackCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgument;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.minecraft.RunsafeConsole;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Base class representing a command that can only be executed by the console and has an implementation that can be executed asynchronously with a return value
 * WARNING: Do not call bukkit APIs from the background thread!
 */
public abstract class ConsoleAsyncCallbackCommand<T> extends AsyncCallbackCommand<T> implements IConsoleAsyncCallbackExecute<T>
{
	protected ConsoleAsyncCallbackCommand(String name, String description, IScheduler scheduler, IArgument... args)
	{
		super(name, description, null, scheduler, args);
	}

	@Nullable
	@Override
	public final String OnExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		return null;
	}

	@SuppressWarnings("InstanceofInterfaces")
	@Nullable
	@Override
	public final T OnAsyncExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		if (executor instanceof RunsafeConsole)
			return OnAsyncExecute(parameters);
		return null;
	}

	/**
	 * This method is called on the main thread before {@link ConsoleAsyncCallbackCommand#OnAsyncExecute(Map)}
	 * Override this method if you don't use optional arguments
	 *
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show in the console
	 */
	@Override
	@Nullable
	public String OnExecute(IArgumentList parameters)
	{
		return null;
	}
}
