package no.runsafe.framework.api.command.argument;

import javax.annotation.Nullable;

public interface IValueExpander
{
	@Nullable
	String expand(String value);
}
