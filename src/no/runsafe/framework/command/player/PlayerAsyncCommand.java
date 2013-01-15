package no.runsafe.framework.command.player;

import no.runsafe.framework.command.AsyncCommand;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.timer.IScheduler;

import java.util.HashMap;

public abstract class PlayerAsyncCommand extends AsyncCommand
{
	public PlayerAsyncCommand(String name, String description, String permission, IScheduler scheduler, String... args)
	{
		super(name, description, permission, scheduler, args);
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafePlayer)
			return OnExecute((RunsafePlayer) executor, parameters, arguments);
		return "This command cannot be used from the console.";
	}

	@Override
	public final String OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafePlayer)
			return OnAsyncExecute((RunsafePlayer) executor, parameters, arguments);
		return "This command cannot be used from the console.";
	}

	public String OnExecute(RunsafePlayer executor, HashMap<String, String> parameters, String[] arguments)
	{
		return OnExecute(executor, parameters);
	}

	public String OnExecute(RunsafePlayer executor, HashMap<String, String> parameters)
	{
		return null;
	}

	public String OnAsyncExecute(RunsafePlayer executor, HashMap<String, String> parameters, String[] arguments)
	{
		return OnAsyncExecute(executor, parameters);
	}

	public abstract String OnAsyncExecute(RunsafePlayer executor, HashMap<String, String> parameters);
}
