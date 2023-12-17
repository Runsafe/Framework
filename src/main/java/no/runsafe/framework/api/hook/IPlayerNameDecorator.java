package no.runsafe.framework.api.hook;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;

public interface IPlayerNameDecorator extends IFrameworkHook
{
	/**
	 * Called by {@link RunsafePlayer#getPrettyName()} to decorate a player name for output
	 */
	String DecorateName(IPlayer player, String name);
}
