package no.runsafe.framework.api.hook;

import java.util.List;

public interface IUniverseMapper extends IFrameworkHook
{
	List<String> GetUniverses();
	Iterable<String> GetWorlds(String universe);
	String GetUniverse(String world);
}
