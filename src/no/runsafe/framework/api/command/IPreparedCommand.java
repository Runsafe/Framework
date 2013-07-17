package no.runsafe.framework.api.command;

import java.util.List;

public interface IPreparedCommand
{
	String getRequiredPermission();
	String execute();
	List<String> tabComplete(String[] args);
}
