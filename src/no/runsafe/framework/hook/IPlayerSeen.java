package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerSeen extends FrameworkHook
{
	/**
	 * Called by {@link no.runsafe.framework.server.player.RunsafePlayer#getLastSeen(no.runsafe.framework.server.player.RunsafePlayer)} to get their last seen time.
	 */
	String GetLastSeen(RunsafePlayer player, RunsafePlayer checker);
}
