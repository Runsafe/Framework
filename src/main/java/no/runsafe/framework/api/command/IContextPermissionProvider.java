package no.runsafe.framework.api.command;

import no.runsafe.framework.api.command.argument.IArgumentList;

public interface IContextPermissionProvider
{
	String getPermission(ICommandExecutor executor, IArgumentList parameters, String... args);
}
