package no.runsafe.framework.api.command;

public interface IPreparedCommand
{
	String getRequiredPermission();

	String execute();
}
