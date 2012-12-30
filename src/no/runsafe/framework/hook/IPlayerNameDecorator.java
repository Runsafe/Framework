package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerNameDecorator
{
	String DecorateName(RunsafePlayer player, String name);
}
