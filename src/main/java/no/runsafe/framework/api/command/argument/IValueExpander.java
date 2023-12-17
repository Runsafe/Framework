package no.runsafe.framework.api.command.argument;

import no.runsafe.framework.api.command.ICommandExecutor;

import javax.annotation.Nullable;

public interface IValueExpander
{
	@Nullable
	String expand(ICommandExecutor context, @Nullable String value);
}
