package no.runsafe.framework.api.hook;

import java.util.List;

public interface IPlayerLookupService extends IFrameworkHook
{
	/**
	 * Called to autocomplete partial names
	 */
	List<String> findPlayer(String lookup);
}
