package no.runsafe.framework.command.player;

import no.runsafe.framework.command.AsyncCallbackCommand;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.server.RunsafeConsole;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.timer.IScheduler;

import java.util.HashMap;

public abstract class PlayerAsyncCallbackCommand<T> extends AsyncCallbackCommand<T>
{
	public PlayerAsyncCallbackCommand(String name, String description, String permission, IScheduler scheduler, String... args)
	{
		super(name, description, permission, scheduler, args);
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafeConsole)
			return "This command cannot be used from the console.";
		return OnExecute((RunsafePlayer) executor, parameters, arguments);
	}

	@Override
	public final T OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafePlayer)
			return OnAsyncExecute((RunsafePlayer) executor, parameters, arguments);
		return null;
	}

	public String OnExecute(RunsafePlayer executor, HashMap<String, String> parameters, String[] arguments)
	{
		return OnExecute(executor, parameters);
	}

	public String OnExecute(RunsafePlayer executor, HashMap<String, String> parameters)
	{
		return null;
	}

	public T OnAsyncExecute(RunsafePlayer executor, HashMap<String, String> parameters, String[] arguments)
	{
		return OnAsyncExecute(executor, parameters);
	}

	public abstract T OnAsyncExecute(RunsafePlayer executor, HashMap<String, String> parameters);
}
