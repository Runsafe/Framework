package no.runsafe.framework.api.command;

import com.google.common.collect.Maps;
import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.command.argument.IArgument;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.command.argument.IValueExpander;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.internal.command.PreparedSynchronousCommand;
import no.runsafe.framework.internal.command.argument.ArgumentList;
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
	public Command(
		@Nonnull String commandName, @Nonnull String description, @Nullable String permission,
		IArgument... arguments
	)
	{
		validate(arguments);
		name = commandName;
		this.permission = permission;
		this.description = description;
		Map<String, IArgument> argumentMap = new LinkedHashMap<String, IArgument>(arguments.length);
		for (IArgument argument : arguments)
			argumentMap.put(argument.toString(), argument);
		argumentList = Collections.unmodifiableMap(argumentMap);
	}

	/**
	 * Builds the usage message when an incomplete command is issued.
	 *
	 * @return A String to display to the player or console user
	 */
	@Nonnull
	@Override
	public String getUsage(@Nonnull ICommandExecutor executor)
	{
		Map<String, String> available = getAvailableSubCommands(executor);
		List<String> usage = new ArrayList<String>(subCommands.size());
		if (available.isEmpty())
			return "\n " + description;

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

	@Nonnull
	@Override
	public String getSubCommandUsage(@Nonnull ICommandExecutor executor, String... path)
	{
		if (path.length == 0)
			return getUsageCommandParams(executor) + ' ' + getUsage(executor);

		ICommandHandler subCommand = getSubCommand(executor, path[0]);
		if (subCommand == null)
			return "There is no such subcommand.";

		return getUsageCommandParams(executor) + ' ' + subCommand.getSubCommandUsage(executor, Arrays.copyOfRange(path, 1, path.length));
	}

	/**
	 * The command arguments listed in usage is built by this.
	 * Override this if you have optional arguments
	 *
	 * @param executor The player or console executing the command
	 * @return List of arguments for inclusion in the command usage
	 */
	@Nonnull
	@Override
	public String getUsageCommandParams(ICommandExecutor executor)
	{
		StringBuilder parts = new StringBuilder(ChatColour.BLUE + name + ChatColour.RESET);
		if (!argumentList.isEmpty())
			for (IArgument argument : argumentList.values())
				parts.append(' ').append(getUsageCommandArgument(executor, argument));

		return parts.toString();
	}

	private static String getUsageCommandArgument(ICommandExecutor executor, IArgument arg)
	{
		String argument = arg.toString();
		boolean isRequired = arg.isRequired();
		if (arg instanceof IValueExpander)
		{
			String defaultValue = ((IValueExpander) arg).expand(executor, null);
			if (defaultValue != null)
			{
				argument += '=' + defaultValue;
				isRequired = false;
			}
			else
				isRequired = true;
		}
		return String.format(
			isRequired ? "<%s%s%s>%s" : "[%s%s%s]%s",
			ChatColour.YELLOW, argument, ChatColour.RESET,
			arg.isWhitespaceInclusive() ? "+" : ""
		);
	}

	/**
	 * @return The permission required to execute this command
	 */
	@Nullable
	@Override
	public final String getPermission()
	{
		return permission;
	}

	@Nullable
	@Override
	public String getEffectivePermission(IArgumentList params)
	{
		if (permission == null)
			return null;
		String effectivePermission = permission;
		Matcher permissionParams = paramPermission.matcher(effectivePermission);
		while (permissionParams.find())
		{
			String param = permissionParams.group(1);
			String paramTag = permissionParams.group(0);
			if (params.has(param))
			{
				if (params.getValue(param) != null)
					effectivePermission = effectivePermission.replace(paramTag, params.getValue(param));
			}
			else if (argumentList.containsKey(param))
			{
				if (argumentList.get(param) != null)
					effectivePermission = effectivePermission.replace(paramTag, argumentList.get(param));
			}
		}
		return effectivePermission;
	}

	/**
	 * Adds a subcommand to this command
	 *
	 * @param subCommand The subcommand to add to this command
	 */
	public final void addSubCommand(ICommandHandler subCommand)
	{
		subCommands.put(subCommand.getName(), subCommand);
	}

	/**
	 * Resolve a subcommand
	 *
	 * @param executor The player or console executing the command
	 * @param name     The partial or full subcommand name
	 * @return The selected subcommand or null if no matches
	 */
	@SuppressWarnings("VariableNotUsedInsideIf")
	@Nullable
	public final ICommandHandler getSubCommand(ICommandExecutor executor, String name)
	{
		if (subCommands.isEmpty())
			return null;

		if (subCommands.containsKey(name))
			return subCommands.get(name);

		String target = null;
		for (String sub : subCommands.keySet())
			if (sub.startsWith(name))
			{
				if (target != null)
					return null;

				target = sub;
			}
		if (target != null)
			return subCommands.get(target);

		return null;
	}

	@Override
	@Nullable
	public final ICommandHandler getTargetSubCommand(ICommandExecutor executor, String... path)
	{
		if (path.length == 0)
			return this;
		ICommandHandler subCommand = getSubCommand(executor, path[0]);
		if (subCommand == null)
			return null;
		return subCommand.getTargetSubCommand(executor, Arrays.copyOfRange(path, 1, path.length));
	}

	@Nonnull
	@Override
	public final List<String> getSubCommands(ICommandExecutor executor)
	{
		List<String> available = new ArrayList<String>(subCommands.size());
		for (Map.Entry<String, ICommandHandler> stringCommandEntry : subCommands.entrySet())
			if (stringCommandEntry.getValue().isTabCompletable(executor))
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

	@Nonnull
	@Override
	public String getDescription()
	{
		return description;
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
		console.debugFiner("Preparing command %s %s", name, StringUtils.join(args, " "));
		return prepareCommand(executor, new HashMap<String, String>(args.length), args, new Stack<ICommandHandler>());
	}

	@Override
	public IPreparedCommand prepareTabComplete(ICommandExecutor executor, String... args)
	{
		console.debugFiner("Preparing command %s %s for tab completion", name, StringUtils.join(args, " "));
		return prepareTabCompleteCommand(executor, new HashMap<String, String>(args.length), args, new Stack<ICommandHandler>());
	}

	@Override
	@Nonnull
	public final IPreparedCommand prepareTabCompleteCommand(
		@Nonnull ICommandExecutor executor,
		@Nonnull Map<String, String> params,
		@Nonnull String[] arguments,
		@Nonnull Stack<ICommandHandler> stack
	)
	{
		stack.add(this);
		String[] args = extractSubCommandArguments(executor, params, arguments);
		IArgumentList myargs = new ArgumentList(executor, populateArgumentList(stack), params);
		String permission = getEffectivePermission(myargs);
		if (args.length > 0 && (permission == null || paramPermission.matcher(permission).find() || executor.hasPermission(permission)))
		{
			console.debugFiner("Looking for subcommand %s for tab completion", args[0]);
			ICommandHandler subCommand = getSubCommand(executor, args[0]);
			if (subCommand != null && subCommand.isTabCompletable(executor))
			{
				subCommand.setConsole(console);
				args = Arrays.copyOfRange(args, 1, args.length);
				console.debugFiner("Preparing subcommand %s for tab completion", executor.getName());
				return subCommand.prepareTabCompleteCommand(executor, params, args, stack);
			}
		}
		return stack.peek().createAction(executor, stack, args, myargs);
	}

	@Nonnull
	@Override
	public final IPreparedCommand prepareCommand(
		@Nonnull ICommandExecutor executor,
		@Nonnull Map<String, String> params,
		@Nonnull String[] arguments,
		@Nonnull Stack<ICommandHandler> stack
	)
	{
		stack.add(this);
		String[] args = extractSubCommandArguments(executor, params, arguments);
		IArgumentList myargs = new ArgumentList(executor, populateArgumentList(stack), params);
		if (args.length > 0)
		{
			console.debugFiner("Looking for subcommand %s", args[0]);
			ICommandHandler subCommand = getSubCommand(executor, args[0]);
			if (subCommand != null)
			{
				subCommand.setConsole(console);
				args = Arrays.copyOfRange(args, 1, args.length);
				console.debugFiner("Preparing subcommand %s", executor.getName());
				return subCommand.prepareCommand(executor, params, args, stack);
			}
		}
		return stack.peek().createAction(executor, stack, args, myargs);
	}

	private String[] extractSubCommandArguments(ICommandExecutor executor, Map<String, String> params, String[] arguments)
	{
		String[] args = arguments;
		Map<String, String> myParams = parseParameters(executor, args);
		if (!myParams.isEmpty())
		{
			params.putAll(myParams);
			args = args.length <= myParams.size()
				? new String[0] :
				Arrays.copyOfRange(args, myParams.size(), args.length);
		}
		console.debugFiner("Command %s has %d parameters and %d args", name, myParams.size(), args.length);
		return args;
	}

	private Map<String, IArgument> populateArgumentList(Stack<ICommandHandler> stack)
	{
		Map<String, IArgument> myargs = Maps.newHashMap(argumentList);
		for (ICommandHandler command : stack)
		{
			for (IArgument argument : command.getParameters())
				if (!myargs.containsKey(argument.toString()))
					myargs.put(argument.toString(), argument);
		}
		return myargs;
	}

	@Nonnull
	@Override
	public IPreparedCommand createAction(
		@Nonnull ICommandExecutor executor,
		@Nonnull Stack<ICommandHandler> stack,
		@Nonnull String[] args,
		@Nonnull IArgumentList params
	)
	{
		console.debugFiner("Preparing Sync command with %d params and %d args", params.size(), args.length);
		return new PreparedSynchronousCommand(executor, stack, args, params);
	}

	/**
	 * Called by the framework to register a console object for debug output
	 *
	 * @param console The console to print debug information to
	 */
	@Override
	public void setConsole(@Nonnull IDebug console)
	{
		console.debugFiner("Setting console on command object.");
		this.console = console;
	}

	@Nonnull
	@Override
	public List<IArgument> getParameters()
	{
		return ImmutableList.copyOf(argumentList.values());
	}

	@Override
	public boolean isTabCompletable(@Nonnull ICommandExecutor executor)
	{
		if (permission == null)
		{
			for (ICommandHandler subCommand : subCommands.values())
				if (subCommand.isTabCompletable(executor))
					return true;

			return !getClass().equals(Command.class);
		}
		Matcher myParams = paramPermission.matcher(permission);
		return (myParams.find() || executor.hasPermission(permission));
	}

	@Override
	public boolean isExecutable(ICommandExecutor executor, IArgumentList params)
	{
		if (permission == null)
			return !getClass().equals(Command.class);

		return executor.hasPermission(getEffectivePermission(params));
	}

	private static void validate(IArgument... arguments)
	{
		boolean optional = false;
		boolean whitespace = false;
		for (IArgument argument : arguments)
		{
			if (whitespace)
				throw new IllegalArgumentException("Whitespace may only be captured by the final argument!");

			if (optional && argument.isRequired())
				throw new IllegalArgumentException("There may not be required parameters after an optional one!");

			if (!argument.isRequired())
				optional = true;

			if (argument.isWhitespaceInclusive())
				whitespace = true;
		}
	}

	private Map<String, String> getAvailableSubCommands(ICommandExecutor executor)
	{
		Map<String, String> available = new HashMap<String, String>(subCommands.size());
		for (ICommandHandler sub : subCommands.values())
		{
			if (sub.isTabCompletable(executor))
				available.put(sub.getName(), String.format(" - %s", sub.getDescription()));
		}
		return available;
	}

	private Map<String, String> parseParameters(ICommandExecutor context, String... args)
	{
		Map<String, String> parameters = new HashMap<String, String>(args.length);

		int index = 0;
		for (IArgument parameter : argumentList.values())
		{
			if (parameter.isWhitespaceInclusive())
			{
				if (args.length > index)
				{
					parameters.put(parameter.toString(), StringUtils.join(args, " ", index, args.length));
					break;
				}
			}

			String value = null;
			if (args.length > index)
				value = args[index];
			if (parameter instanceof IValueExpander)
				value = ((IValueExpander) parameter).expand(context, value);
			index++;
			if (parameter.isRequired() || value != null && !value.isEmpty())
				parameters.put(parameter.toString(), value);
		}
		return parameters;
	}

	protected IDebug console;
	protected final Map<String, IArgument> argumentList;
	private final Map<String, ICommandHandler> subCommands = new HashMap<String, ICommandHandler>(0);
	private final String name;
	private final String permission;
	private final String description;
	public static final Pattern QUOTED_ARGUMENT = Pattern.compile("\"(.+)\"");
	private static final Pattern paramPermission = Pattern.compile("<(.*)>");
}
