package no.runsafe.framework.api.command;

import java.util.List;
import java.util.Map;

public interface IPreparedCommand
{
	String getRequiredPermission();
	String execute();
	List<String> tabComplete(String[] args);
}
