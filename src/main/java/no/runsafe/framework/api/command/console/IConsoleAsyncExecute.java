package no.runsafe.framework.api.command.console;

import no.runsafe.framework.api.command.argument.IArgumentList;

public interface IConsoleAsyncExecute extends IConsoleExecute
{
	/**
	 * If you use optional arguments, you still need to override this, but you can leave it empty.
	 *
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show in the console after the command completes
	 */
	String OnAsyncExecute(IArgumentList parameters);
}
