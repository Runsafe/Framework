package no.runsafe.framework.command;

import no.runsafe.framework.output.Console;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class RunsafeCommand implements ICommand
{
	public RunsafeCommand(String name, Collection<ICommand> subs, String... params)
	{
		commandName = name;
		subCommands = new HashMap<String, ICommand>();
		this.params = new HashMap<String, String>();
		if (params != null)
		{
			for(String param : params)
				this.params.put(param, null);
		}
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
	public String getCommandUsage()
	{
		String usage = "/" + getCommandParams();
		if(subCommands != null && !subCommands.isEmpty())
			usage += String.format(" [%s]", StringUtils.join(subCommands.keySet(), "|"));
		return usage;
	}

	@Override
	public String getCommandParams()
	{
		String part = commandName;
		if(!params.isEmpty())
			part += " <" + StringUtils.join(params.keySet(), "> <") + ">";

		if(superCommand != null)
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
		if(requiredPermission() == null)
			return true;

		return player.hasPermission(requiredPermission());
	}

	@Override
	public boolean Execute(RunsafePlayer player, String[] args)
	{
		subArgOffset = 0;
		if(!CanExecute(player, args))
		{
			player.sendMessage(String.format("%sRequired permission %s missing.", ChatColor.RED, requiredPermission()));
			return true;
		}

		if(args.length < params.size())
		{
			player.sendMessage(getCommandUsage());
			return true;
		}
		captureArgs(args);

		ICommand sub = null;
		if (args != null && args.length > subArgOffset)
			sub = getSubCommand(args[subArgOffset]);

		if(sub != null)
			subArgOffset++;

		else
		{
			player.sendMessage(OnExecute(args));
			return true;
		}

		return sub.Execute(player, getSubArgs(args));
	}

	@Override
	public boolean Execute(String[] args)
	{
		subArgOffset = 0;
		if(args.length < params.size())
		{
			Console.write(getCommandUsage());
			return true;
		}
		captureArgs(args);

		ICommand sub = null;
		if(args != null && args.length > subArgOffset)
			sub = getSubCommand(args[0]);

		if(sub != null)
			subArgOffset++;

		else
		{
			Console.write(OnExecute(args));
			return true;
		}

		return sub.Execute(getSubArgs(args));
	}

	@Override
	public String OnExecute(String[] args)
	{
		return getCommandUsage();
	}

	@Override
	public void setSuperCommand(ICommand command)
	{
		superCommand = command;
	}

	@Override
	public String getArg(String name)
	{
		if(params.containsKey(name))
			return params.get(name);

		return null;
	}

	protected void captureArgs(String[] args)
	{
		if(!params.isEmpty())
			for(String param : params.keySet())
				params.put(param, args[subArgOffset++]);
	}

	protected ICommand getSubCommand(String name)
	{
		if(subCommands.containsKey(name))
			return subCommands.get(name);

		for(String sub : subCommands.keySet())
			if(sub.startsWith(name))
				return subCommands.get(sub);

		return null;
	}

	private String[] getSubArgs(String[] args)
	{
		if (args.length == 1 || args.length == 0)
			return new String[]{};

		return Arrays.copyOfRange(args, subArgOffset, args.length);
	}

	protected ICommand superCommand;
	protected HashMap<String, ICommand> subCommands;
	protected String commandName;
	protected int subArgOffset;
	protected HashMap<String, String> params;
}
