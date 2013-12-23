package no.runsafe.framework.internal;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.hook.IUniverseMapper;
import no.runsafe.framework.minecraft.Universe;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class gets called automatically to collect universes from plugins
 */
public final class Multiverse
{
	public static Multiverse Get()
	{
		return InjectionPlugin.getGlobalComponent(Multiverse.class);
	}

	public Multiverse(IServer server)
	{
		this.server = server;
	}

	@Nullable
	public Universe getByName(String name)
	{
		return scan(name);
	}

	@Nullable
	public Universe getByWorld(IWorld world)
	{
		return scan(world.getName());
	}

	public List<IWorld> getAllWorlds()
	{
		return server.getWorlds();
	}

	@Nullable
	public IWorld getWorld(String name)
	{
		if (name == null)
			return null;
		return server.getWorld(name);
	}

	public void addUniversesForMapper(IUniverseMapper mapper)
	{
		mappers.add(mapper);
	}

	private Universe scan(String worldName)
	{
		for (IUniverseMapper mapper : mappers)
			for (String universeName : mapper.GetUniverses())
			{
				List<String> worlds = Lists.newArrayList(mapper.GetWorlds(universeName));
				if (worlds.contains(worldName))
				{
					Universe universe = new Universe(universeName);
					for (String world : worlds)
						universe.addWorld(getWorld(world));
					return universe;
				}
			}

		return new Universe(worldName);
	}

	private final IServer server;
	private final List<IUniverseMapper> mappers = new ArrayList<IUniverseMapper>(0);
}
