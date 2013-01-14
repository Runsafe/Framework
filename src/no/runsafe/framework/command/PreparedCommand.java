package no.runsafe.framework.command;

import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.timer.IScheduler;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Pattern;

public final class PreparedCommand
{
	public PreparedCommand(
		ICommandExecutor executor,
		Stack<Command> definingCommand,
		String[] args,
		HashMap<String, String> parameters)
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
			{
				if (target instanceof AsyncCommand)
					((AsyncCommand) target).Schedule(this);
				if (target instanceof AsyncCallbackCommand)
					((AsyncCallbackCommand) target).Schedule(this);
				return ((ExecutableCommand) target).OnExecute(executor, parameters, arguments);
			}
		}

		ArrayList<String> params = new ArrayList<String>();
		for (Command tier : command)
			params.add(tier.getUsageCommandParams());

		return String.format("Usage: /%1$s %2$s", StringUtils.join(params, " "), target.getUsage());
	}

	public void Schedule(final IScheduler scheduler)
	{
		final AsyncCommand target = (AsyncCommand) command.peek();
		scheduler.startAsyncTask(
			new Runnable()
			{
				@Override
				public void run()
				{
					final String result = target.OnAsyncExecute(executor, parameters, arguments);
					if (result != null && executor != null)
						scheduler.startSyncTask(
							new Runnable()
							{
								@Override
								public void run()
								{
									executor.sendColouredMessage(result);
								}
							}, 1L
						);
				}
			},
			1L
		);
	}

	public void ScheduleCallback(final IScheduler scheduler)
	{
		final AsyncCallbackCommand target = (AsyncCallbackCommand) command.peek();
		scheduler.startAsyncTask(
			new Runnable()
			{
				@Override
				public void run()
				{
					final Object result = target.OnAsyncExecute(executor, parameters, arguments);
					scheduler.startSyncTask(
						new Runnable()
						{
							@Override
							public void run()
							{
								target.SyncPostExecute(result);
							}
						}, 1L
					);
				}
			},
			1L
		);
	}


	private final ICommandExecutor executor;
	private final Stack<Command> command;
	private final String[] arguments;
	private final HashMap<String, String> parameters;
	private final String requiredPermission;
	private final static Pattern paramPermission = Pattern.compile(".*<.*>.*");
}
