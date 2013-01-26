package no.runsafe.framework.command.console;

import no.runsafe.framework.command.ExecutableCommand;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.server.RunsafeConsole;

import java.util.HashMap;

/**
 * Base class representing a command that can only be executed by the console
 */
public abstract class ConsoleCommand extends ExecutableCommand
{
	public ConsoleCommand(String commandName, String description, String... arguments)
	{
		super(commandName, description, null, arguments);
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafeConsole)
			return OnExecute(parameters, arguments);

		return "This command must be used from the console.";
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters)
	{
		if (executor instanceof RunsafeConsole)
			return OnExecute(parameters);

		return "This command must be used from the console.";
	}

	/**
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
	 * If you use optional arguments, you must still override this command but you can leave it blank.
	 *
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show in the console
	 */
	public abstract String OnExecute(HashMap<String, String> parameters);
}
