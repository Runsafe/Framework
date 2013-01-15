package no.runsafe.framework.command.console;

import no.runsafe.framework.command.ExecutableCommand;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.server.RunsafeConsole;

import java.util.HashMap;

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

	public String OnExecute(HashMap<String, String> parameters, String[] arguments)
	{
		return OnExecute(parameters);
	}

	public abstract String OnExecute(HashMap<String, String> parameters);
}
