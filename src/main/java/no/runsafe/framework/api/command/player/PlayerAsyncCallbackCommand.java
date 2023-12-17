package no.runsafe.framework.api.command.player;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.command.AsyncCallbackCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.argument.IArgument;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.RunsafeConsole;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;

import javax.annotation.Nullable;

/**
 * Base class representing a command that can only be executed by a player and has an implementation that can be executed asynchronously with a return value
 * WARNING: Do not call bukkit APIs from the background thread!
 */
@SuppressWarnings("InstanceofInterfaces")
public abstract class PlayerAsyncCallbackCommand<T> extends AsyncCallbackCommand<T> implements IPlayerAsyncCallbackExecute<T>
{
	protected PlayerAsyncCallbackCommand(String name, String description, String permission, IScheduler scheduler, IArgument... args)
	{
		super(name, description, permission, scheduler, args);
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		if (executor instanceof RunsafeConsole)
			return "This command cannot be used from the console.";
		return OnExecute((IPlayer) executor, parameters);
	}

	@Override
	@Nullable
	public final T OnAsyncExecute(ICommandExecutor executor, IArgumentList parameters)
	{
		if (executor instanceof RunsafePlayer)
			return OnAsyncExecute((IPlayer) executor, parameters);
		return null;
	}

	/**
	 * This method is called on the main thread before {@link no.runsafe.framework.api.command.IAsyncCallbackExecute#OnAsyncExecute(no.runsafe.framework.api.command.ICommandExecutor, no.runsafe.framework.api.command.argument.IArgumentList)}
	 *
	 *
	 * @param executor   The player executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show to the user running the command
	 */
	@Override
	@Nullable
	public String OnExecute(IPlayer executor, IArgumentList parameters)
	{
		return null;
	}
}
