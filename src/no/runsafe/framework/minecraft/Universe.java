package no.runsafe.framework.minecraft;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.hook.IUniverseMapper;
import no.runsafe.framework.internal.HookEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Universe
{
	public Universe(String name)
	{
		this.name = name;
	}

	public String GetName()
	{
		return name;
	}

	public List<RunsafeWorld> GetWorlds()
	{
		List<IUniverseMapper> dataHooks = HookEngine.hookContainer.getComponents(IUniverseMapper.class);
		Map<String, RunsafeWorld> worlds = new HashMap<String, RunsafeWorld>();
		for (IUniverseMapper mapper : dataHooks)
		{
			for (String world : mapper.GetWorlds(name))
				if (!worlds.containsKey(world))
					worlds.put(world, RunsafeServer.Instance.getWorld(world));
		}
		return Lists.newArrayList(worlds.values());
	}

	private final String name;
}
