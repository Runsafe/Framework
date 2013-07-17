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
import org.bukkit.craftbukkit.libs.joptsimple.internal.Strings;

import javax.annotation.Nullable;
import java.util.*;
import java.util.regex.Pattern;

public abstract class PreparedCommand implements IPreparedCommand
{
	public PreparedCommand(
		ICommandExecutor executor, Stack<Command> definingCommand, String[] args, HashMap<String, String> parameters)
	{
		this.executor = executor;
		this.command = definingCommand;
		this.arguments = args;
		this.parameters = parameters;
		Command execute = command.peek();
		String permission = null;
		if (execute instanceof IContextPermissionProvider)
			permission = ((IContextPermissionProvider) execute).getPermission(executor, parameters, args);
		if (permission == null)
			permission = command.peek().getPermission();
		if (permission != null)
			for (String param : parameters.keySet())
				if (parameters.get(param) != null)
					permission = permission.replace("<" + param + ">", parameters.get(param));
		this.requiredPermission = permission;
	}

	@Override
	public String getRequiredPermission()
	{
		if (requiredPermission == null || paramPermission.matcher(requiredPermission).matches())
			return null;
		return requiredPermission;
	}

	@Override
	public List<String> tabComplete(String[] args)
	{
		String last = null;
		int i = 0;
		for (Command cmd : command)
		{
			if (cmd == command.peek())
				break;
			i += cmd.getParameters().size(); // Args taken by command
			i++; // Arg taken by selecting subcommand
		}
		List<String> params = command.peek().getParameters();
		Set<String> subcommands = command.peek().getSubCommands();
		boolean takeParams = params != null && !params.isEmpty();
		boolean takeSub = subcommands != null && !subcommands.isEmpty();

		RunsafeServer.Instance.getDebugger()
			.fine("TabComplete: params=%s/%d, sub=%s/%d", params, takeParams ? 1 : 0, subcommands, takeSub ? 1 : 0);

		if (!takeParams && !takeSub)
			return null;

		if (!takeSub && args.length - i >= params.size())
			return null;


		if (takeSub && (!takeParams || args.length - i >= params.size()))
		{
			RunsafeServer.Instance.getDebugger().fine("Filter on: %s", args[i + (takeParams ? params.size() : 0)]);
			return filterList(command.peek().getSubCommands(), args[i + (takeParams ? params.size() : 0)]);
		}

		for (String param : command.peek().getParameters())
		{
			if (last == null)
				last = param;
			if (parameters.get(param) == null)
				break;
			last = param;
		}
		RunsafeServer.Instance.getDebugger().fine("TabComplete: last=%s", last);
		RunsafeServer.Instance.getDebugger().fine("TabComplete: param=%s", parameters.get(last));
		RunsafeServer.Instance.getDebugger().fine("TabComplete: args=[%s]", Strings.join(args, ","));
		String filter = "";
		if (parameters.get(last) != null && !parameters.get(last).isEmpty())
		{
			if (args[args.length - 1].isEmpty())
			{
				Set<String> subs = command.peek().getSubCommands();
				if (subs != null)
					return Lists.newArrayList(subs);
				return null;
			}
			else
				filter = args[args.length - 1];
		}
		if (last != null)
		{
			if (last.equalsIgnoreCase("player"))
				return filterList(getPlayers(), filter);

			if (last.equalsIgnoreCase("world"))
				return filterList(getWorlds(), filter);
		}
		return filterList(command.peek().getParameterOptions(last), filter);
	}

	private List<String> filterList(Iterable<String> values, String filter)
	{
		if (filter == null || filter.isEmpty())
			return Lists.newArrayList(values);
		List<String> matches = new ArrayList<String>();
		for (String value : values)
			if (value.toLowerCase().startsWith(filter.toLowerCase()))
				matches.add(value);
		return matches;
	}

	private List<String> getPlayers()
	{
		return RunsafeServer.Instance.getOnlinePlayers((RunsafePlayer) executor, parameters.get("player"));
	}

	private List<String> getWorlds()
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
		ArrayList<String> params = new ArrayList<String>();
		for (Command tier : command)
			params.add(tier.getUsageCommandParams());

		return String.format("Usage: /%1$s %2$s", StringUtils.join(params, " "), target.getUsage(executor));
	}

	protected final ICommandExecutor executor;
	protected final Stack<Command> command;
	protected final String[] arguments;
	protected final HashMap<String, String> parameters;
	private final String requiredPermission;
	private final static Pattern paramPermission = Pattern.compile(".*<.*>.*");
}
