package no.runsafe.framework.api.command;

import no.runsafe.framework.api.command.argument.IArgumentList;

public interface ISyncExecute
{
	/**
	 * The implementation of the command.
	 * If you use optional arguments, you still need to override this method, just leave it empty.
	 *
	 * @param executor   The player or console executing the command
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show to the user running the command
	 */
	String OnExecute(ICommandExecutor executor, IArgumentList parameters);
}
