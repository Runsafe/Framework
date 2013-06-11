package no.runsafe.framework.api.command;

import java.util.HashMap;

public interface IContextPermissionProvider
{
	String getPermission(ICommandExecutor executor, HashMap<String, String> parameters, String[] args);
}
