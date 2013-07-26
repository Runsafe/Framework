package no.runsafe.framework.internal.command.prepared;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import no.runsafe.framework.api.command.Command;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.IContextPermissionProvider;
import no.runsafe.framework.api.command.IPreparedCommand;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Nullable;
import java.util.*;
import java.util.regex.Pattern;

public abstract class PreparedCommand implements IPreparedCommand
{
	protected PreparedCommand(
		ICommandExecutor executor, Stack<Command> definingCommand, String[] args, Map<String, String> parameters)
	{
		this.executor = executor;
		command = definingCommand;
		arguments = args;
		this.parameters = parameters;
		Command execute = command.peek();
		String permission = null;
		if (execute instanceof IContextPermissionProvider)
			permission = ((IContextPermissionProvider) execute).getPermission(executor, parameters, args);
		if (permission == null)
			permission = command.peek().getPermission();
		if (permission != null)
			for (Map.Entry<String, String> parameter : parameters.entrySet())
				if (parameter.getValue() != null)
					permission = permission.replace('<' + parameter.getKey() + '>', parameter.getValue());
		requiredPermission = permission;
	}

	@Override
	@Nullable
	public String getRequiredPermission()
	{
		if (requiredPermission == null || paramPermission.matcher(requiredPermission).matches())
			return null;
		return requiredPermission;
	}

	@SuppressWarnings("OverlyComplexMethod")
	@Override
	@Nullable
	public Iterable<String> tabComplete(String... args)
	{
		int i = 0;
		for (Command cmd : command)
		{
			if (cmd.equals(command.peek()))
				break;
			i += cmd.getParameters().size(); // Args taken by command
			i++; // Arg taken by selecting the next subcommand
		}
		List<String> params = command.peek().getParameters();
		List<String> subcommands = command.peek().getSubCommands(executor);
		boolean takeParams = !params.isEmpty();
		boolean takeSub = !subcommands.isEmpty();

		RunsafeServer.Instance.getDebugger().finer(
			"TabComplete: [taken %d, free %d] params=%s:%d, sub=%s:%d",
			i, args.length - i,
			params, takeParams ? 1 : 0,
			subcommands, takeSub ? 1 : 0
		);

		if (!takeParams && !takeSub)
			return Lists.newArrayList();

		if (args.length > i + params.size() + 1)
			return null;

		if (takeParams && args.length - i > 0 && args.length - i <= params.size())
		{
			String param = params.get(args.length - i - 1);
			List<String> matches;
			if (param.equalsIgnoreCase("player"))
				matches = getPlayers();

			else if (param.equalsIgnoreCase("world"))
				matches = getWorlds();

			else
			{
				matches = command.peek().getParameterOptionsPartial(param, args[args.length - 1]);
				if (matches != null)
				{
					if (matches.isEmpty())
						return null;
					return matches;
				}
				matches = command.peek().getParameterOptions(param);
				if (matches == null)
					return Lists.newArrayList();
			}
			RunsafeServer.Instance.getDebugger().finer(
				"TabComplete: param=%s, matches=%s, filter=%d",
				param, matches, args[args.length - 1].isEmpty() ? 0 : 1
			);
			return args[args.length - 1].isEmpty() ? matches : filterList(matches, args[args.length - 1]);
		}

		if (takeSub)
		{
			return filterList(command.peek().getSubCommands(executor), args[args.length - 1]);
		}

		// If capturing tail - allow tab completion of names in final parameter
		return command.peek().isCapturingTail() ? null : Lists.<String>newArrayList();
	}

	private static List<String> filterList(Iterable<String> values, String filter)
	{
		if (filter == null || filter.isEmpty())
			return Lists.newArrayList(values);
		List<String> matches = new ArrayList<String>(1);
		for (String value : values)
			if (value.toLowerCase().startsWith(filter.toLowerCase()))
				matches.add(value);
		return matches;
	}

	private List<String> getPlayers()
	{
		return RunsafeServer.Instance.getOnlinePlayers((RunsafePlayer) executor, parameters.get("player"));
	}

	private static List<String> getWorlds()
	{
		return Lists.transform(
			RunsafeServer.Instance.getWorlds(),
			new Function<RunsafeWorld, String>()
			{
				@Override
				public String apply(@Nullable RunsafeWorld runsafeWorld)
				{
					assert runsafeWorld != null;
					return runsafeWorld.getName();
				}
			}
		);
	}

	protected String usage(Command target)
	{
		Collection<String> params = new ArrayList<String>(command.size());
		for (Command tier : command)
			params.add(tier.getUsageCommandParams());

		//noinspection HardcodedFileSeparator
		return String.format("Usage: /%1$s %2$s", StringUtils.join(params, " "), target.getUsage(executor));
	}

	protected final ICommandExecutor executor;
	protected final Stack<Command> command;
	protected final String[] arguments;
	protected final Map<String, String> parameters;
	private final String requiredPermission;
	private static final Pattern paramPermission = Pattern.compile(".*<.*>.*");
}
