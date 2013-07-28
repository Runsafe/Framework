package no.runsafe.framework.api.command;

import java.util.Map;

public interface IAsyncExecute
{
	/**
	 * If you use optional arguments, you still need to override this but you can leave it empty.
	 *
	 * @param executor   The console or player executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show to the user running the command
	 */
	String OnAsyncExecute(ICommandExecutor executor, Map<String, String> parameters);
}
