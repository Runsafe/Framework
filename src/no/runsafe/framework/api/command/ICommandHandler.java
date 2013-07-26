package no.runsafe.framework.api.command;

import no.runsafe.framework.api.IOutput;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public interface ICommandHandler
{
	@Nonnull
	IPreparedCommand prepare(ICommandExecutor executor, String... args);

	@Nonnull
	String getName();

	void setConsole(IOutput console);

	@Nullable
	List<String> getParameterOptions(String parameter);

	@Nullable
	Iterable<String> getParameterOptionsPartial(String parameter, String arg);

	@Nonnull
	List<String> getParameters();

	@Nonnull
	List<String> getSubCommands(ICommandExecutor executor);

	boolean isCapturingTail();
}
