package no.runsafe.framework.command;

import no.runsafe.framework.command.prepared.IPreparedCommand;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ICommandExecutor;

public interface ICommandHandler
{
	IPreparedCommand prepare(ICommandExecutor executor, String[] args);

	String getName();

	void setConsole(IOutput console);
}
