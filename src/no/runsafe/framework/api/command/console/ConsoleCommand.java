package no.runsafe.framework.api.command.console;

import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgument;
import no.runsafe.framework.minecraft.RunsafeConsole;

import java.util.Map;

/**
 * Base class representing a command that can only be executed by the console
 */
public abstract class ConsoleCommand extends ExecutableCommand implements IConsoleExecute
{
	@Deprecated
	protected ConsoleCommand(String commandName, String description, CharSequence... arguments)
	{
		super(commandName, description, null, arguments);
	}

	protected ConsoleCommand(String commandName, String description, IArgument... arguments)
	{
		super(commandName, description, null, arguments);
	}


	@Override
	public final String OnExecute(ICommandExecutor executor, Map<String, String> parameters)
	{
		if (executor instanceof RunsafeConsole)
			return OnExecute(parameters);

		return "This command must be used from the console.";
	}
}
