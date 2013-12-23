package no.runsafe.framework.minecraft;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.IWorld;

import javax.annotation.Nonnull;
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

	@Nonnull
	public List<IWorld> getWorlds()
	{
		return Lists.newArrayList(worlds.values());
	}

	public void addWorld(IWorld world)
	{
		if (world != null && !worlds.containsKey(world.getName()))
			worlds.put(world.getName(), world);
	}

	public void removeWorld(String name)
	{
		if (worlds.containsKey(name))
			worlds.remove(name);
	}

	private final String name;
	private final Map<String, IWorld> worlds = new HashMap<String, IWorld>(1);
}
