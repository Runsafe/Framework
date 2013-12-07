package no.runsafe.framework.api.command.player;

import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public interface IPlayerAsyncCallbackExecute<T> extends IPlayerExecute
{
	/**
	 * If you use optional arguments, you still need to override this but you can leave it empty.
	 *
	 * @param executor   The player executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show to the user running the command
	 */
	T OnAsyncExecute(IPlayer executor, Map<String, String> parameters);
}
