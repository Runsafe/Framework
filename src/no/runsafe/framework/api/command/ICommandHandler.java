package no.runsafe.framework.api.command;

import no.runsafe.framework.api.IOutput;

public interface ICommandHandler
{
	IPreparedCommand prepare(ICommandExecutor executor, String[] args);

	String getName();

	void setConsole(IOutput console);
}
