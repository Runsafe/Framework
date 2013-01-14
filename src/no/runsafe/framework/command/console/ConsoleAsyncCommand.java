package no.runsafe.framework.command.console;

import no.runsafe.framework.command.AsyncCommand;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.server.RunsafeConsole;
import no.runsafe.framework.timer.IScheduler;

import java.util.HashMap;

public abstract class ConsoleAsyncCommand extends AsyncCommand
{
	public ConsoleAsyncCommand(String name, String description, String permission, IScheduler scheduler, String... args)
	{
		super(name, description, permission, scheduler, args);
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafeConsole)
			return OnExecute(parameters, arguments);
		return "This command must be used from the console.";
	}

	@Override
	public final String OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafeConsole)
			return OnAsyncExecute((RunsafeConsole) executor, parameters, arguments);
		return "This command must be used from the console.";
	}

	public String OnExecute(HashMap<String, String> parameters, String[] arguments)
	{
		return null;
	}

	public abstract String OnAsyncExecute(RunsafeConsole executor, HashMap<String, String> parameters, String[] arguments);
}
