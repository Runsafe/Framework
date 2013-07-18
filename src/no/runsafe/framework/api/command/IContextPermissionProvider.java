package no.runsafe.framework.api.command;

import java.util.Map;

public interface IContextPermissionProvider
{
	String getPermission(ICommandExecutor executor, Map<String, String> parameters, String... args);
}
