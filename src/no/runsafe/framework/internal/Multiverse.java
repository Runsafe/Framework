package no.runsafe.framework.internal;

import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.hook.IUniverseMapper;
import no.runsafe.framework.minecraft.Universe;
import org.picocontainer.Startable;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class gets called automatically to collect universes from plugins
 */
@SuppressWarnings({"NonThreadSafeLazyInitialization", "StaticVariableUsedBeforeInitialization"})
public class Multiverse implements Startable
{
	@Nullable
	public static Universe getByName(String name)
	{
		if (name != null && universes.containsKey(name))
			return universes.get(name);
		return null;
	}

	@Nullable
	public static Universe getByWorld(IWorld world)
	{
		if (!worldMap.containsKey(world.getName()))
			createDefaultUniverse(world);

		return worldMap.get(world.getName());
	}

	public static List<IWorld> getAllWorlds()
	{
		return server.getWorlds();
	}

	@Nullable
	public static IWorld getWorld(String name)
	{
		if (name == null)
			return null;
		return server.getWorld(name);
	}

	private static void createDefaultUniverse(IWorld world)
	{
		universes.put(world.getName(), new Universe(world.getName()));
		universes.get(world.getName()).addWorld(world);
		worldMap.put(world.getName(), universes.get(world.getName()));
	}

	public Multiverse(IServer server)
	{
		if (Multiverse.server == null)
			Multiverse.server = server;
	}

	@SuppressWarnings({"OverloadedVarargsMethod"})
	public Multiverse(IServer server, IUniverseMapper... providers)
	{
		if (Multiverse.server == null)
			Multiverse.server = server;
		for (IUniverseMapper mapper : providers)
			addUniversesForMapper(mapper);
	}

	@Override
	public void start()
	{
	}

	@Override
	public void stop()
	{
	}

	private static void addUniversesForMapper(IUniverseMapper mapper)
	{
		for (String universe : mapper.GetUniverses())
		{
			if (!universes.containsKey(universe))
				universes.put(universe, new Universe(universe));
			addWorldsForUniverse(universes.get(universe), mapper.GetWorlds(universe));
		}
	}

	private static void addWorldsForUniverse(Universe universe, Iterable<String> worlds)
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

	private static IServer server;
	private static final Map<String, Universe> universes = new HashMap<String, Universe>(1);
	private static final Map<String, Universe> worldMap = new HashMap<String, Universe>(1);
}
