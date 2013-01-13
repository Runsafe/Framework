package no.runsafe.framework.command;

import no.runsafe.framework.server.player.RunsafePlayer;

public interface ICommandHandler
{
	PreparedCommand prepare(RunsafePlayer executor, String[] args);

	String getName();
}
