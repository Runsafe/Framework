package no.runsafe.framework.command;

import no.runsafe.framework.server.ICommandExecutor;

import java.util.HashMap;

public interface IContextPermissionProvider
{
	String getPermission(ICommandExecutor executor, HashMap<String, String> parameters, String[] args);
}
