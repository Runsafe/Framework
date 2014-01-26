package no.runsafe.framework.api.command;

import no.runsafe.framework.api.command.argument.IArgument;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.log.IDebug;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public interface ICommandHandler
{
	@Nonnull
	String getName();

	@Nonnull
	String getDescription();

	void setConsole(@Nonnull IDebug console);

	@Nonnull
	List<IArgument> getParameters();

	@Nullable
	ICommandHandler getTargetSubCommand(ICommandExecutor executor, String... path);

	@Nonnull
	List<String> getSubCommands(ICommandExecutor executor);

	@Nonnull
	String getUsageCommandParams(ICommandExecutor executor);

	@Nullable
	String getPermission();

	@Nonnull
	String getUsage(@Nonnull ICommandExecutor executor);

	@Nonnull
	String getSubCommandUsage(@Nonnull ICommandExecutor executor, String... path);

	boolean isExecutable(@Nonnull ICommandExecutor executor);

	@Nonnull
	IPreparedCommand prepare(ICommandExecutor executor, String... args);

	@Nonnull
	IPreparedCommand prepareCommand(
		@Nonnull ICommandExecutor executor,
		@Nonnull Map<String, String> params,
		@Nonnull String[] args,
		@Nonnull Stack<ICommandHandler> stack
	);

	@Nonnull
	IPreparedCommand createAction(
		@Nonnull ICommandExecutor executor,
		@Nonnull Stack<ICommandHandler> stack,
		@Nonnull String[] args,
		@Nonnull IArgumentList params
	);
}
