package no.runsafe.framework.command;

import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.Collection;

public interface ICommand
{
	public boolean Execute(RunsafePlayer player, String[] args);
	public boolean Execute(String[] args);

	String getCommandName();

	String requiredPermission();

	Collection<ICommand> getSubCommands();

	void addSubCommand(ICommand command);
}
