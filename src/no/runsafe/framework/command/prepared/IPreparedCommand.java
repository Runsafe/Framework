package no.runsafe.framework.command.prepared;

public interface IPreparedCommand
{
	String getRequiredPermission();

	String execute();
}
