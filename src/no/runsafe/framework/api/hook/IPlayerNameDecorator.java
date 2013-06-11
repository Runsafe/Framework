package no.runsafe.framework.api.hook;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IPlayerNameDecorator extends IFrameworkHook
{
	/**
	 * Called by {@link no.runsafe.framework.minecraft.player.RunsafePlayer#getPrettyName()} to decorate a player name for output
	 */
	String DecorateName(RunsafePlayer player, String name);
}
