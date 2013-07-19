package no.runsafe.framework.api.command;

import javax.annotation.Nullable;

public interface IPreparedCommand
{
	@Nullable
	String getRequiredPermission();
	@Nullable
	String execute();
	@Nullable
	Iterable<String> tabComplete(String... args);
}
