package no.runsafe.framework.command;

import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.Collection;

/**
 * Only use this if you cannot use Async commands.
 */
@Deprecated
public class RunsafeConsoleCommand extends RunsafeCommand
{
	public RunsafeConsoleCommand(String name, String... params)
	{
		super(name, params);
	}

	@Override
	public boolean Execute(RunsafePlayer player, String[] args)
	{
		player.sendMessage("This command must be used from the console.");
		return true;
	}
}
