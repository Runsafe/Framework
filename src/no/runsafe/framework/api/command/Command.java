package no.runsafe.framework.api.command;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.internal.command.prepared.PreparedAsynchronousCallbackCommand;
import no.runsafe.framework.internal.command.prepared.PreparedAsynchronousCommand;
import no.runsafe.framework.internal.command.prepared.PreparedSynchronousCommand;
import no.runsafe.framework.text.ChatColour;
import org.apache.commons.lang.StringUtils;
import org.bukkit.craftbukkit.libs.joptsimple.internal.Strings;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The base command class of the framework
 * Create instances of this object for commands that only contain subcommands
 */
public class Command implements ICommandHandler
{
	/**
	 * Defines the command
	 *
	 * @param commandName The name of the command. For top level commands, this must be as defined in plugin.yml
	 * @param description A short descriptive text of what the command does
	 * @param permission  A permission String that a player must have to run the command or null to allow anyone to run it
	 * @param arguments   Optional list of required command parameters
	 */
	public Command(String commandName, String description, String permission, String... arguments)
	{
		name = commandName;
		this.permission = permission;
		this.description = description;
		argumentList = arguments == null ? ImmutableList.<String>of() : ImmutableList.copyOf(arguments);
	}

	/**
	 * Builds the usage message when an incomplete command is issued.
	 *
	 * @return A String to display to the player or console user
	 */
	public String getUsage(ICommandExecutor executor)
	{
		Map<String, String> available = getAvailableSubCommands(executor);
		List<String> usage = new ArrayList<String>(subCommands.size());
		if (available.isEmpty())
			return description == null ? "" : description;

		String format = "  %s%s%s: %s";
		for (Map.Entry<String, String> stringStringEntry : available.entrySet())
			usage.add(String.format(format, ChatColour.YELLOW, stringStringEntry.getKey(), ChatColour.RESET, stringStringEntry.getValue()));

		return String.format(
			"<%1$scommand%2$s>\nAvailable commands:\n%3$s",
			ChatColour.YELLOW,
			ChatColour.RESET,
			Strings.join(usage, "\n")
		);
	}

	private Map<String, String> getAvailableSubCommands(ICommandExecutor executor)
	{
		Map<String, String> available = new HashMap<String, String>(subCommands.size());
		for (Command sub : subCommands.values())
		{
			if (sub.isExecutable(executor))
			{
				if (sub.description == null)
					available.put(sub.name, "");
				else
					available.put(sub.name, String.format(" - %s", sub.description));
			}
		}
		return available;
	}

	/**
	 * The command arguments listed in usage is built by this.
	 * Override this if you have optional arguments
	 *
	 * @return List of arguments for inclusion in the command usage
	 */
	public String getUsageCommandParams()
	{
		String part = ChatColour.BLUE + name + ChatColour.RESET;
		if (!argumentList.isEmpty())
			part += " <" +
				ChatColour.YELLOW + StringUtils.join(
				argumentList,
				ChatColour.RESET + "> <" + ChatColour.YELLOW
			) + ChatColour.RESET + '>';
		return part;
	}

	/**
	 * @return The permission required to execute this command
	 */
	public final String getPermission()
	{
		return permission;
	}

	/**
	 * Adds a subcommand to this command
	 *
	 * @param subCommand The subcommand to add to this command
	 */
	public final void addSubCommand(Command subCommand)
	{
		subCommands.put(subCommand.name, subCommand);
	}

	/**
	 * Resolve a subcommand
	 *
	 * @param executor The player or console executing the command
	 * @param name     The partial or full subcommand name
	 * @return The selected subcommand or null if no matches
	 */
	@Nullable
	public final Command getSubCommand(ICommandExecutor executor, String name)
	{
		if (subCommands.isEmpty())
			return null;

		if (subCommands.containsKey(name))
			return subCommands.get(name);

		String target = null;
		for (String sub : subCommands.keySet())
			if (sub.startsWith(name) && subCommands.get(sub).isExecutable(executor))
			{
				if (target != null)
					return null;

				target = sub;
			}
		if (target != null)
			return subCommands.get(target);

		return null;
	}

	@Nonnull
	@Override
	public final List<String> getSubCommands(ICommandExecutor executor)
	{
		List<String> available = new ArrayList<String>(subCommands.size());
		for (Map.Entry<String, Command> stringCommandEntry : subCommands.entrySet())
			if (stringCommandEntry.getValue().isExecutable(executor))
				available.add(stringCommandEntry.getKey());
		return available;
	}

	/**
	 * @return The name of this command
	 */
	@Nonnull
	@Override
	public final String getName()
	{
		return name;
	}

	/**
	 * Call this method in your constructor if the final parameter should grab all tailing arguments
	 * i.e. if you want to support spaces without "" for input to a command
	 */
	protected final void captureTail()
	{
		captureTail = true;
	}

	@Override
	public final boolean isCapturingTail()
	{
		return captureTail;
	}

	/**
	 * Parses user input and returns a prepared command, ready to be executed
	 *
	 * @param executor The user or console executing the command
	 * @param args     The passed argument list
	 * @return A prepared command, ready to be executed
	 */
	@Nonnull
	@Override
	public final IPreparedCommand prepare(ICommandExecutor executor, @Nonnull String... args)
	{
		console.finer("Preparing command %s %s", name, StringUtils.join(args, " "));
		return prepare(executor, new HashMap<String, String>(args.length), args, new Stack<Command>());
	}

	/**
	 * Called by the framework to register a console object for debug output
	 *
	 * @param console The console to print debug information to
	 */
	@Override
	public void setConsole(IOutput console)
	{
		console.finer("Setting console on command object.");
		this.console = console;
	}

	@Nullable
	@Override
	public List<String> getParameterOptions(String parameter)
	{
		return null;
	}

	@Nullable
	@Override
	public List<String> getParameterOptionsPartial(String parameter, String arg)
	{
		return null;
	}

	@Nonnull
	@Override
	public List<String> getParameters()
	{
		return Collections.unmodifiableList(argumentList);
	}

	private IPreparedCommand prepare(ICommandExecutor executor, Map<String, String> params, String[] args, Stack<Command> stack)
	{
		stack.add(this);
		Map<String, String> myParams = getParameters(args);
		params.putAll(myParams);
		if (!myParams.isEmpty())
		{
			args = captureTail || args.length <= myParams.size()
				? new String[0] :
				Arrays.copyOfRange(args, myParams.size(), args.length);
		}
		console.finer("Command %s has %d parameters and %d args", name, myParams.size(), args.length);
		if (args.length > 0)
		{
			console.finer("Looking for subcommand %s", args[0]);
			Command subCommand = getSubCommand(executor, args[0]);
			if (subCommand != null && subCommand.isExecutable(executor))
			{
				subCommand.setConsole(console);
				args = Arrays.copyOfRange(args, 1, args.length);
				console.finer("Preparing subcommand %s", executor.getName());
				return subCommand.prepare(executor, params, args, stack);
			}
		}

		if (stack.peek() instanceof AsyncCallbackCommand)
		{
			console.finer("Preparing AsyncCallback command with %d params and %d args", params.size(), args.length);
			return new PreparedAsynchronousCallbackCommand(executor, stack, args, params);
		}
		if (stack.peek() instanceof AsyncCommand)
		{
			console.finer("Preparing Async command with %d params and %d args", params.size(), args.length);
			return new PreparedAsynchronousCommand(executor, stack, args, params);
		}
		console.finer("Preparing Sync command with %d params and %d args", params.size(), args.length);
		return new PreparedSynchronousCommand(executor, stack, args, params);
	}

	@SuppressWarnings("MethodWithMultipleLoops")
	private boolean isExecutable(ICommandExecutor executor)
	{
		if (permission == null)
		{
			for (Command subCommand : subCommands.values())
				if (subCommand.isExecutable(executor))
					return true;

			return !getClass().equals(Command.class);
		}
		Matcher params = paramPermission.matcher(permission);
		if (params.find())
		{
			Iterable<String> options = getParameterOptions(params.group());
			if (options == null)
				return true;
			for (String value : options)
				if (executor.hasPermission(params.replaceAll(value)))
					return true;
			return false;
		}
		return executor.hasPermission(permission);
	}

	private Map<String, String> getParameters(String... args)
	{
		Map<String, String> parameters = new HashMap<String, String>(args.length);

		int index = 0;
		for (String parameter : argumentList)
		{
			String value = null;
			if (args.length > index)
				value = args[index];
			index++;
			parameters.put(parameter, value);
		}
		if (captureTail && args.length > index)
			parameters.put(argumentList.get(index - 1), StringUtils.join(args, " ", index - 1, args.length));
		return parameters;
	}

	protected IOutput console;
	private final ImmutableList<String> argumentList;
	private final Map<String, Command> subCommands = new HashMap<String, Command>(0);
	private final String name;
	private final String permission;
	private final String description;
	private boolean captureTail;
	private static final Pattern paramPermission = Pattern.compile("<(.*)>");
}
