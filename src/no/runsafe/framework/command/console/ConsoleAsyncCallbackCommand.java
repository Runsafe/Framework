package no.runsafe.framework.command.console;

import no.runsafe.framework.command.AsyncCallbackCommand;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.server.RunsafeConsole;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.timer.IScheduler;

import java.util.HashMap;

public abstract class ConsoleAsyncCallbackCommand<T> extends AsyncCallbackCommand<T>
{
	public ConsoleAsyncCallbackCommand(String name, String description, IScheduler scheduler, String... args)
	{
		super(name, description, null, scheduler, args);
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafePlayer)
			return "This command must be used from the console.";
		return OnExecute(parameters, arguments);
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters)
	{
		return null;
	}

	@Override
	public final T OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafeConsole)
			return OnAsyncExecute(parameters, arguments);
		return null;
	}

	@Override
	public final T OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters)
	{
		if (executor instanceof RunsafeConsole)
			return OnAsyncExecute(parameters);
		return null;
	}

	public String OnExecute(HashMap<String, String> parameters, String[] arguments)
	{
		return OnExecute(parameters);
	}

	public String OnExecute(HashMap<String, String> parameters)
	{
		return null;
	}

	public T OnAsyncExecute(HashMap<String, String> parameters, String[] arguments)
	{
		return OnAsyncExecute(parameters);
	}

	public abstract T OnAsyncExecute(HashMap<String, String> parameters);
}
