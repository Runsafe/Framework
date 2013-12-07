package no.runsafe.framework.minecraft;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.IWorld;
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

	public String getName()
	{
		return name;
	}

	@SuppressWarnings("MethodWithMultipleLoops")
	public List<IWorld> getWorlds()
	{
		List<IUniverseMapper> dataHooks = HookEngine.hookContainer.getComponents(IUniverseMapper.class);
		Map<String, IWorld> worlds = new HashMap<String, IWorld>(RunsafeServer.Instance.getWorlds().size());
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
