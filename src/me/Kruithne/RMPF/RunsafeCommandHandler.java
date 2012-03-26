package me.Kruithne.RMPF;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public abstract class RunsafeCommandHandler implements CommandExecutor {

	public RunsafeCommandHandler()
	{
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		ArrayList<String> argList = new ArrayList<String>();
		for(String argument : args)
		{
			if(!argument.trim().isEmpty())
				argList.add(argument);
		}
		if(sender instanceof Player)
		{
			return this.playerExecute((Player)sender, argList);
		}
		else 
		{
			if(this.getConsoleAccessible())
				return this.consoleExecute((ConsoleCommandSender)sender, argList);
			else
				sender.sendMessage(ChatColor.RED + "You must be a player!");
		}
		return false;
	}
	
//	public abstract String getCommandName();
//	public abstract List<String> getCommandAliases();
	
	public abstract String getName();
	protected abstract boolean getConsoleAccessible();
	
	protected boolean playerExecute(Player player, List<String> args)
	{
		return false;
	}
	
	protected boolean consoleExecute(ConsoleCommandSender console, List<String> args)
	{
		return false;
	}
}