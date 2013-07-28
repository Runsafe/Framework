package no.runsafe.framework.api.command.player;

import no.runsafe.framework.api.command.AsyncCallbackCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.minecraft.RunsafeConsole;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.framework.api.IScheduler;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Base class representing a command that can only be executed by a player and has an implementation that can be executed asynchronously with a return value
 * WARNING: Do not call bukkit APIs from the background thread!
 */
public abstract class PlayerAsyncCallbackCommand<T> extends AsyncCallbackCommand<T> implements IPlayerAsyncCallbackExecute<T>
{
	protected PlayerAsyncCallbackCommand(String name, String description, String permission, IScheduler scheduler, CharSequence... args)
	{
		super(name, description, permission, scheduler, args);
	}

	@Override
	public final String OnExecute(ICommandExecutor executor, Map<String, String> parameters)
	{
		if (executor instanceof RunsafeConsole)
			return "This command cannot be used from the console.";
		return OnExecute((RunsafePlayer) executor, parameters);
	}

	@Override
	@Nullable
	public final T OnAsyncExecute(ICommandExecutor executor, Map<String, String> parameters)
	{
		if (executor instanceof RunsafePlayer)
			return OnAsyncExecute((RunsafePlayer) executor, parameters);
		return null;
	}

	/**
	 * This method is called on the main thread before {@link PlayerAsyncCallbackCommand#OnAsyncExecute(ICommandExecutor, Map)}
	 *
	 * @param executor   The player executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show to the user running the command
	 */
	@Nullable
	public String OnExecute(RunsafePlayer executor, Map<String, String> parameters)
	{
		return null;
	}
}
