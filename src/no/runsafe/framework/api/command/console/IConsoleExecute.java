package no.runsafe.framework.api.command.console;

import java.util.Map;

public interface IConsoleExecute
{
	/**
	 * If you use optional arguments, you must still override this command but you can leave it blank.
	 *
	 * @param parameters The arguments you defined in the constructor and their values as supplied by the user
	 * @return Message to show in the console
	 */
	String OnExecute(Map<String, String> parameters);
}
