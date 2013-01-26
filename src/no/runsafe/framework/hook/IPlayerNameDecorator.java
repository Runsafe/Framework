package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerNameDecorator extends FrameworkHook
{
	/**
	 * Called by {@link no.runsafe.framework.server.player.RunsafePlayer#getPrettyName()} to decorate a player name for output
	 */
	String DecorateName(RunsafePlayer player, String name);
}
