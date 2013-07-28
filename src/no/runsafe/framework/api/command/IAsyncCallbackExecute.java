package no.runsafe.framework.api.command;

import java.util.HashMap;
import java.util.Map;

public interface IAsyncCallbackExecute<T>
{
	@Deprecated
	T OnAsyncExecute(ICommandExecutor executor, Map<String, String> parameters, String... arguments);

	/**
	 * If you have optional arguments, you still need to override this method but you can leave it empty.
	 *
	 * @param executor   The player or console executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Data object that gets passed to SyncPostExecute
	 */
	T OnAsyncExecute(ICommandExecutor executor, Map<String, String> parameters);

	/**
	 * This method gets called on the main thread after the {@link AsyncCallbackCommand#OnAsyncExecute(ICommandExecutor, HashMap)} completes
	 *
	 * @param result The value returned from the background thread
	 */
	void SyncPostExecute(T result);
}
