package no.runsafe.framework.api.command;

import no.runsafe.framework.api.command.argument.IArgument;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Base class representing a command that has an implementation that can be executed
 */
public abstract class ExecutableCommand extends Command implements ISyncExecute
{
	/**
	 * Defines the command
	 *
	 * @param commandName The name of the command. For top level commands, this must be as defined in plugin.yml
	 * @param description A short descriptive text of what the command does
	 * @param permission  A permission String that a player must have to run the command or null to allow anyone to run it
	 * @param arguments   Optional list of required command parameters
	 */
	protected ExecutableCommand(@Nonnull String commandName, @Nonnull String description, @Nullable String permission, IArgument... arguments)
	{
		super(commandName, description, permission, arguments);
	}
}
