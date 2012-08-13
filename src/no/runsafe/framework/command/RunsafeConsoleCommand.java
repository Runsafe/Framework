package no.runsafe.framework.command;

import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.Collection;

/**
 * Only use this if you cannot use Async commands.
 */
public class RunsafeConsoleCommand extends RunsafeCommand
{
	public RunsafeConsoleCommand(String name, Collection<ICommand> subs, String... params)
	{
		super(name, subs, params);
	}

	@Override
	public boolean Execute(RunsafePlayer player, String[] args)
	{
		player.sendMessage("This command must be used from the console.");
		return true;
	}
}