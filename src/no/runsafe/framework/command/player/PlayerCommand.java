package no.runsafe.framework.command.player;

import no.runsafe.framework.command.ExecutableCommand;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.HashMap;

public abstract class PlayerCommand extends ExecutableCommand
{
	public PlayerCommand(String commandName, String description, String permission, String... arguments)
	{
		super(commandName, description, permission, arguments);
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		if (executor instanceof RunsafePlayer)
			return OnExecute((RunsafePlayer) executor, parameters, arguments);

		return "This command cannot be used from the console.";
	}

	public abstract String OnExecute(RunsafePlayer executor, HashMap<String, String> parameters, String[] arguments);
}
