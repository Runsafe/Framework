package no.runsafe.framework.internal.command;

import no.runsafe.framework.api.command.ICommandHandler;
import org.bukkit.command.TabExecutor;

public interface ITabExecutor extends TabExecutor
{
	String getName();

	ICommandHandler getHandler();
}
