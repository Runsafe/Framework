package no.runsafe.framework.internal.command.prepared;

@Deprecated
public abstract class Command extends no.runsafe.framework.api.command.Command
{
	/**
	 * Defines the command
	 *
	 * @param commandName The name of the command. For top level commands, this must be as defined in plugin.yml
	 * @param description A short descriptive text of what the command does
	 * @param permission  A permission string that a player must have to run the command or null to allow anyone to run it
	 * @param arguments   Optional list of required command parameters
	 */
	public Command(String commandName, String description, String permission, String... arguments)
	{
		super(commandName, description, permission, arguments);
	}
}
