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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
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
	public List<String> tabComplete()
	{
		String last = null;
		for (String param : command.peek().getParameters())
		{
			if (last == null)
				last = param;
			if (parameters.get(param) == null)
				break;
			last = param;
		}
		if(last != null && last.equalsIgnoreCase("player") && executor instanceof RunsafePlayer)
			return RunsafeServer.Instance.getOnlinePlayers((RunsafePlayer)executor, parameters.get("player"));
		if(last != null && last.equalsIgnoreCase("world"))
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
		return command.peek().getParameterOptions(last);
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
