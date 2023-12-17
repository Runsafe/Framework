package no.runsafe.framework.api.hook;

import no.runsafe.framework.api.IUniverseManager;

import java.util.List;

public interface IUniverseMapper extends IFrameworkHook
{
	List<String> GetUniverses();
	Iterable<String> GetWorlds(String universe);
	String GetUniverse(String world);
	void setManager(IUniverseManager manager);
}
