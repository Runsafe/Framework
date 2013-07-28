package no.runsafe.framework.api.command.console;

import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.minecraft.RunsafeConsole;

import java.util.Map;

/**
 * Base class representing a command that can only be executed by the console
 */
public abstract class ConsoleCommand extends ExecutableCommand
{
	protected ConsoleCommand(String commandName, String description, CharSequence... arguments)
	{
		super(commandName, description, null, arguments);
	}

	@Override
	@Deprecated
	public final String OnExecute(ICommandExecutor executor, Map<String, String> parameters, String... arguments)
	{
		if (executor instanceof RunsafeConsole)
			return OnExecute(parameters, arguments);

		return "This command must be used from the console.";
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, Map<String, String> parameters)
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
	@Deprecated
	public String OnExecute(Map<String, String> parameters, String... arguments)
	{
		return OnExecute(parameters);
	}

	/**
	 * If you use optional arguments, you must still override this command but you can leave it blank.
	 *
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show in the console
	 */
	public abstract String OnExecute(Map<String, String> parameters);
}
