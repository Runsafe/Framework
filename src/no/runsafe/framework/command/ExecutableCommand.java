package no.runsafe.framework.command;

import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.HashMap;

public abstract class ExecutableCommand extends Command
{
	public ExecutableCommand(String commandName, String description, String permission, String... arguments)
	{
		super(commandName, description, permission, arguments);
	}

	public abstract String OnExecute(RunsafePlayer executor, HashMap<String, String> parameters, String[] arguments);
}
