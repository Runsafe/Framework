package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerNameDecorator extends FrameworkHook
{
	String DecorateName(RunsafePlayer player, String name);
}
