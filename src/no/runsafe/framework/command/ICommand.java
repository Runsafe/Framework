package no.runsafe.framework.command;

import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.Collection;

public interface ICommand {
	boolean CanExecute(RunsafePlayer player, String[] args);

	boolean Execute(RunsafePlayer player, String[] args);

	boolean Execute(String[] args);

	String OnExecute(RunsafePlayer executor, String[] args);

	String getCommandName();

	String getCommandUsage();

	String getCommandParams();

	String requiredPermission();

	Collection<ICommand> getSubCommands();

	void addSubCommand(ICommand command);

	void setSuperCommand(ICommand command);

	String getArg(String name);

	void setConsole(IOutput output);
}
