package no.runsafe.framework.command;

import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class RunsafeCommand implements ICommand
{
	public RunsafeCommand(String name, Collection<ICommand> subs)
	{
		commandName = name;
		subCommands = new HashMap<String, ICommand>();
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
	public Collection<ICommand> getSubCommands()
	{
		return subCommands.values();
	}

	@Override
	public void addSubCommand(ICommand command)
	{
		subCommands.put(command.getCommandName(), command);
	}

	@Override
	public String requiredPermission()
	{
		return null;
	}

	@Override
	public boolean Execute(RunsafePlayer player, String[] args)
	{
		if (args != null && args.length > 0 && subCommands.containsKey(args[0]))
		{
			ICommand command = subCommands.get(args[0]);
			if (command.requiredPermission() != null && !player.hasPermission(command.requiredPermission()))
			{
				player.sendMessage(ChatColor.RED + "No access to that command.");
				return true;
			}
			return subCommands.get(args[0]).Execute(player, getSubArgs(args));
		}
		return false;
	}

	@Override
	public boolean Execute(String[] args)
	{
		return args != null && args.length > 0
			&& subCommands.containsKey(args[0])
			&& subCommands.get(args[0]).Execute(getSubArgs(args));
	}

	private String[] getSubArgs(String[] args)
	{
		if (args.length == 1 || args.length == 0)
			return new String[]{};

		return Arrays.copyOfRange(args, 1, args.length);
	}

	private HashMap<String, ICommand> subCommands;
	private String commandName;
}
