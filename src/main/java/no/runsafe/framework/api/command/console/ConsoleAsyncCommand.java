package no.runsafe.framework.api.command.console;

import no.runsafe.framework.api.command.AsyncCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgument;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.minecraft.RunsafeConsole;
import no.runsafe.framework.api.IScheduler;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Base class representing a command that can only be executed by the console and has an implementation that can be executed asynchronously
 * WARNING: Do not call bukkit APIs from the background thread!
 */
public abstract class ConsoleAsyncCommand extends AsyncCommand implements IConsoleAsyncExecute
{
	protected ConsoleAsyncCommand(String name, String description, IScheduler scheduler, IArgument... args)
	{
		super(name, description, null, scheduler, args);
	}

	@SuppressWarnings("InstanceofInterfaces")
	@Override
	public final String OnAsyncExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		if (executor instanceof RunsafeConsole)
			return OnAsyncExecute(parameters);
		return "This command must be used from the console.";
	}

	/**
	 * This method is called on the main thread before {@link ConsoleAsyncCommand#OnAsyncExecute(Map)}
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
