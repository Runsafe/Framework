package no.runsafe.framework.internal;

import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.hook.IUniverseMapper;
import no.runsafe.framework.minecraft.Universe;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		if (name != null && universes.containsKey(name))
			return universes.get(name);
		return null;
	}

	@Nullable
	public Universe getByWorld(IWorld world)
	{
		if (!worldMap.containsKey(world.getName()))
			createDefaultUniverse(world);

		return worldMap.get(world.getName());
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
		for (String universe : mapper.GetUniverses())
		{
			if (!universes.containsKey(universe))
				universes.put(universe, new Universe(universe));
			addWorldsForUniverse(universes.get(universe), mapper.GetWorlds(universe));
		}
	}

	private void createDefaultUniverse(IWorld world)
	{
		universes.put(world.getName(), new Universe(world.getName()));
		universes.get(world.getName()).addWorld(world);
		worldMap.put(world.getName(), universes.get(world.getName()));
	}

	private void addWorldsForUniverse(Universe universe, Iterable<String> worlds)
	{
		for (String world : worlds)
		{
			// If conflicted, last plugin to load wins
			if (worldMap.containsKey(world))
			{
				worldMap.get(world).removeWorld(world);
				worldMap.remove(world);
			}
			universe.addWorld(server.getWorld(world));
			worldMap.put(world, universe);
		}
	}

	private final IServer server;
	private final Map<String, Universe> universes = new HashMap<String, Universe>(1);
	private final Map<String, Universe> worldMap = new HashMap<String, Universe>(1);
}
