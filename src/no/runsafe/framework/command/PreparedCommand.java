package no.runsafe.framework.command;

import no.runsafe.framework.server.player.RunsafePlayer;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Pattern;

public class PreparedCommand
{
	public PreparedCommand(RunsafePlayer executor, Stack<Command> definingCommand, String[] args, HashMap<String, String> parameters)
	{
		this.executor = executor;
		this.command = definingCommand;
		this.arguments = args;
		this.parameters = parameters;
		String permission = command.peek().getPermission();
		if (permission != null)
			for (String param : parameters.keySet())
				if (parameters.get(param) != null)
					permission = permission.replace("<" + param + ">", parameters.get(param));
		this.requiredPermission = permission;
	}

	public String getRequiredPermission()
	{
		if (requiredPermission == null || paramPermission.matcher(requiredPermission).matches())
			return null;
		return requiredPermission;
	}

	public String execute()
	{
		Command target = command.peek();
		if (target instanceof ExecutableCommand)
		{
			if (!parameters.containsValue(null))
				return ((ExecutableCommand) target).OnExecute(executor, parameters, arguments);
		}

		ArrayList<String> params = new ArrayList<String>();
		for (Command tier : command)
			params.add(tier.getUsageCommandParams());

		return String.format("Usage: /%1$s %2$s", StringUtils.join(params, " "), target.getUsage());
	}

	private final RunsafePlayer executor;
	private final Stack<Command> command;
	private final String[] arguments;
	private final HashMap<String, String> parameters;
	private final String requiredPermission;
	private final static Pattern paramPermission = Pattern.compile(".*<.*>.*");
}
