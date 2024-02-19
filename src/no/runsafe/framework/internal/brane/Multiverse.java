package no.runsafe.framework.internal.brane;

import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.IUniverse;
import no.runsafe.framework.api.IUniverseManager;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.hook.IUniverseMapper;
import no.runsafe.framework.internal.InjectionPlugin;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class gets called automatically to collect universes from plugins
 */
public final class Multiverse implements IUniverseManager
{
	public static IUniverseManager getInstance()
	{
		return InjectionPlugin.getGlobalComponent(Multiverse.class);
	}

	public Multiverse(IServer server)
	{
		this.server = server;
	}

	@Override
	@Nullable
	public IUniverse getByName(String name)
	{
		if (!branes.containsKey(name))
			findBrane(name);
		return branes.get(name);
	}

	@Override
	@Nullable
	public IUniverse getByWorld(IWorld world)
	{
		if (!universe.containsKey(world.getName()))
			findUniverse(world.getName());
		return universe.get(world.getName());
	}

	@Override
	public List<IWorld> getAllWorlds()
	{
		return server.getWorlds();
	}

	@Override
	@Nullable
	public IWorld getWorld(String name)
	{
		if (name == null)
			return null;
		return server.getWorld(name);
	}

	@Override
	public void addUniversesForMapper(IUniverseMapper mapper)
	{
		mappers.add(mapper);
	}

	@Override
	public void flush()
	{
		branes.clear();
		universe.clear();
	}

	private void findBrane(String name)
	{
		for (IUniverseMapper mapper : mappers)
			for (String universeName : mapper.GetUniverses())
				if (universeName.equals(name))
				{
					branes.put(name, new Universe(universeName, mapper));
					return;
				}
		branes.put(name, new DefaultUniverse(name));
	}

	private void findUniverse(String name)
	{
		for (IUniverseMapper mapper : mappers)
			for (String universeName : mapper.GetUniverses())
				for (String world : mapper.GetWorlds(universeName))
					if (world.equals(name))
					{
						universe.put(world, new Universe(universeName, mapper));
						return;
					}
		universe.put(name, new DefaultUniverse(name));
	}

	private final Map<String, IUniverse> branes = new ConcurrentHashMap<>();
	private final Map<String, IUniverse> universe = new ConcurrentHashMap<>();
	private final IServer server;
	private final Collection<IUniverseMapper> mappers = new ArrayList<>(0);
}
