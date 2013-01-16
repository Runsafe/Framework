package no.runsafe.framework.hook;

import java.util.List;

public interface IPlayerLookupService extends FrameworkHook
{
	public List<String> findPlayer(String lookup);
}
