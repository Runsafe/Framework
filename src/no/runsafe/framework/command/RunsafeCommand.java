package no.runsafe.framework.command;

import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;

public class RunsafeCommand implements ICommand
{
	public RunsafeCommand(String name, Collection<ICommand> subs, String... params)
	{
		commandName = name;
		subCommands = new HashMap<String, ICommand>();
		this.params = new HashMap<String, String>();
		if (params != null)
		{
			paramKeys = params;
			for (String param : params)
				this.params.put(param, null);
		}
		else
			paramKeys = null;

		if (subs != null)
		{
			for (ICommand command : subs)
				subCommands.put(command.getCommandName(), command);
		}
	}

	@Override
	public String getCommandName()
	{
		return commandName;
	}

	@Override
	public String getCommandUsage(RunsafePlayer executor)
	{
		String usage = "/" + getCommandParams();
		if (subCommands != null && !subCommands.isEmpty())
		{
			ArrayList<String> available = new ArrayList<String>();
			for (ICommand sub : subCommands.values())
				if (executor == null || sub.requiredPermission() == null || executor.hasPermission(sub.requiredPermission()))
					available.add(sub.getCommandName());
			if (available.size() > 0)
				usage += String.format(" %s", StringUtils.join(available, "|"));
		}
		return usage;
	}

	@Override
	public String getCommandParams()
	{
		String part = commandName;
		if (!params.isEmpty())
			part += " <" + StringUtils.join(params.keySet(), "> <") + ">";

		if (superCommand != null)
			return superCommand.getCommandParams() + " " + part;

		return part;
	}

	@Override
	public Collection<ICommand> getSubCommands()
	{
		return subCommands.values();
	}

	@Override
	public void addSubCommand(ICommand command)
	{
		command.setSuperCommand(this);
		subCommands.put(command.getCommandName(), command);
	}

	@Override
	public String requiredPermission()
	{
		return null;
	}

	@Override
	public boolean CanExecute(RunsafePlayer player, String[] args)
	{
		return requiredPermission() == null || player.hasPermission(requiredPermission());
	}

	@Override
	public boolean Execute(RunsafePlayer player, String[] args)
	{
		Console.finer(String.format("Player sync Execute: %s, %s", commandName, StringUtils.join(args, ", ")));

		subArgOffset = 0;
		if (!CanExecute(player, args))
		{
			player.sendMessage(String.format("%sRequired permission %s missing.", ChatColor.RED, requiredPermission()));
			return true;
		}

		if (args.length < params.size())
		{
			player.sendMessage(getCommandUsage(player));
			return true;
		}
		captureArgs(args);

		ICommand sub = null;
		if (args.length > subArgOffset)
			sub = getSubCommand(args[subArgOffset]);

		if (sub != null)
			subArgOffset++;

		else
		{
			String output = OnExecute(player, args);
			if (output != null)
				player.sendMessage(output);
			return true;
		}

		return sub.Execute(player, getSubArgs(args));
	}

	@Override
	public boolean Execute(String[] args)
	{
		Console.finer(String.format("Console sync Execute: %s, %s", commandName, StringUtils.join(args, ", ")));

		subArgOffset = 0;
		if (args.length < params.size())
		{
			Console.finest(String.format("Missing params (%d < %d)", args.length, params.size()));
			Console.write(getCommandUsage(null));
			return true;
		}
		captureArgs(args);

		ICommand sub = null;
		if (args.length > subArgOffset)
			sub = getSubCommand(args[subArgOffset]);

		if (sub != null)
			subArgOffset++;

		else
		{
			Console.finest("Executing command..");
			String output = OnExecute(null, args);
			if (output != null)
				Console.outputColoredToConsole(output, Level.INFO);
			return true;
		}

		Console.finest("Passing command off to subcommand..");
		return sub.Execute(getSubArgs(args));
	}

	@Override
	public String OnExecute(RunsafePlayer executor, String[] args)
	{
		return getCommandUsage(executor);
	}

	@Override
	public void setSuperCommand(ICommand command)
	{
		superCommand = command;
	}

	@Override
	public String getArg(String name)
	{
		if (params.containsKey(name))
			return params.get(name);

		return null;
	}

	@Override
	public void setConsole(IOutput output)
	{
		Console = output;
		for (ICommand sub : subCommands.values())
			sub.setConsole(output);
	}

	protected void captureArgs(String[] args)
	{
		if (paramKeys != null && paramKeys.length > 0)
			for (String param : paramKeys)
				params.put(param, args[subArgOffset++]);
	}

	protected ICommand getSubCommand(String name)
	{
		Console.finest(String.format("Looking up subcommand %s", name));
		if (subCommands.containsKey(name))
		{
			Console.finest("Found exact match..");
			return subCommands.get(name);
		}
		for (String sub : subCommands.keySet())
			if (sub.startsWith(name))
			{
				Console.finest(String.format("Found partial match in %s", sub));
				return subCommands.get(sub);
			}

		Console.finest("Unknown subcommand");
		return null;
	}

	private String[] getSubArgs(String[] args)
	{
		if (args.length == 1 || args.length == 0)
			return new String[]{};

		return Arrays.copyOfRange(args, subArgOffset, args.length);
	}

	protected ICommand superCommand;
	protected final HashMap<String, ICommand> subCommands;
	protected final String commandName;
	protected int subArgOffset;
	protected final String[] paramKeys;
	protected final HashMap<String, String> params;
	protected IOutput Console;
}
