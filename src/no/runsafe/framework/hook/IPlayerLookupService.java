package no.runsafe.framework.hook;

import java.util.List;

public interface IPlayerLookupService extends FrameworkHook
{
	/**
	 * Called by {@link no.runsafe.framework.server.RunsafeServer#getPlayer(String)} to autocomplete partial names
	 */
	public List<String> findPlayer(String lookup);
}
