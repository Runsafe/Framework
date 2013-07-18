package no.runsafe.framework.api.command;

import javax.annotation.Nullable;
import java.util.List;

public interface IPreparedCommand
{
	@Nullable
	String getRequiredPermission();
	@Nullable
	String execute();
	@Nullable
	List<String> tabComplete(String... args);
}
