package no.runsafe.framework.api.command;

import no.runsafe.framework.api.IOutput;

import java.util.List;

public interface ICommandHandler
{
	IPreparedCommand prepare(ICommandExecutor executor, String[] args);

	String getName();

	void setConsole(IOutput console);

	List<String> getParameterOptions(String parameter);

	List<String> getParameters();
}
