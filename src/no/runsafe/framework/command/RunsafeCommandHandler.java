package no.runsafe.framework.command;

import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RunsafeCommandHandler implements CommandExecutor
{

	public RunsafeCommandHandler(ICommand command)
	{
		commandObject = command;
	}

	public String getName()
	{
		return commandObject.getCommandName();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (sender instanceof Player)
		{
			if (commandObject.requiredPermission() != null && !sender.hasPermission(commandObject.requiredPermission()))
			{
				sender.sendMessage(ChatColor.RED + "No access to that command.");
				return true;
			}
			return commandObject.Execute(new RunsafePlayer((Player) sender), args);
		}
		else
			return commandObject.Execute(args);
	}

	private ICommand commandObject;
}