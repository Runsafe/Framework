package no.runsafe.framework.api.hook;

import java.util.List;

public interface IUniverseMapper extends IFrameworkHook
{
	public List<String> GetUniverses();
	public List<String> GetWorlds(String universe);
	public String GetUniverse(String world);
}
