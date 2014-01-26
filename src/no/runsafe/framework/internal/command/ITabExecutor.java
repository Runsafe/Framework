package no.runsafe.framework.internal.command;

import no.runsafe.framework.api.command.ICommandHandler;
import org.bukkit.command.TabExecutor;

import javax.annotation.Nullable;

public interface ITabExecutor extends TabExecutor
{
	String getName();

	@Nullable
	ICommandHandler getHandler();
}
