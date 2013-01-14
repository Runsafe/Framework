package no.runsafe.framework.command;

import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface ICommandHandler
{
	PreparedCommand prepare(ICommandExecutor executor, String[] args);

	String getName();
}
