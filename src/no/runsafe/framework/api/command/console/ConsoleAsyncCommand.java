package no.runsafe.framework.api.command.console;

import no.runsafe.framework.api.command.AsyncCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.minecraft.RunsafeConsole;
import no.runsafe.framework.api.IScheduler;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * Base class representing a command that can only be executed by the console and has an implementation that can be executed asynchronously
 * WARNING: Do not call bukkit APIs from the background thread!
 */
public abstract class ConsoleAsyncCommand extends AsyncCommand implements IConsoleAsyncExecute
{
	protected ConsoleAsyncCommand(String name, String description, IScheduler scheduler, CharSequence... args)
	{
		super(name, description, null, scheduler, args);
	}

	@Override
	public final String OnAsyncExecute(ICommandExecutor executor, Map<String, String> parameters)
	{
		if (executor instanceof RunsafeConsole)
			return OnAsyncExecute(parameters);
		return "This command must be used from the console.";
	}

	/**
	 * This method is called on the main thread before {@link ConsoleAsyncCommand#OnAsyncExecute(HashMap)}
	 * Override this method if you don't use optional arguments
	 *
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show in the console
	 */
	@Nullable
	public String OnExecute(Map<String, String> parameters)
	{
		return null;
	}
}
