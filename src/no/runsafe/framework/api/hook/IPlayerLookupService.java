package no.runsafe.framework.api.hook;

import java.util.List;

public interface IPlayerLookupService extends IFrameworkHook
{
	/**
	 * Called by {@link no.runsafe.framework.minecraft.RunsafeServer#getPlayer(String)} to autocomplete partial names
	 */
	public List<String> findPlayer(String lookup);
}
