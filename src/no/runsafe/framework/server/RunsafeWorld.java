package no.runsafe.framework.server;

import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.item.RunsafeItem;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.server.metadata.RunsafeMetadata;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class RunsafeWorld extends RunsafeMetadata
{
	public RunsafeWorld(World toWrap)
	{
		super(toWrap);
		world = toWrap;
	}

	public RunsafeWorld(String worldName)
	{
		this(RunsafeServer.Instance.getWorld(worldName).getRaw());
	}

	public String getName()
	{
		return world.getName();
	}

	public RunsafeBlock getBlockAt(RunsafeLocation location)
	{
		return new RunsafeBlock(world.getBlockAt(location.getRaw()));
	}

	public RunsafeBlock getBlockAt(int x, int y, int z)
	{
		return new RunsafeBlock(world.getBlockAt(x, y, z));
	}

	public int getBlockTypeIdAt(RunsafeLocation location)
	{
		return world.getBlockTypeIdAt(location.getRaw());
	}

	public int getBlockTypeIdAt(int x, int y, int z)
	{
		return world.getBlockTypeIdAt(x, y, z);
	}

	public RunsafeItem dropItem(RunsafeLocation location, RunsafeItemStack itemStack)
	{
		return new RunsafeItem((world.dropItem(location.getRaw(), itemStack.getRaw())));
	}

	public void strikeLightning(RunsafeLocation location)
	{
		world.strikeLightning(location.getRaw());
	}

	public void createExplosion(RunsafeLocation location, float power, boolean setFire)
	{
		world.createExplosion(location.getRaw(), power, setFire);
	}

	public World getRaw()
	{
		return this.world;
	}

	public int getMaxHeight()
	{
		return world.getMaxHeight();
	}

	public RunsafeEntity spawnCreature(RunsafeLocation location, String type)
	{
		return ObjectWrapper.convert(world.spawnEntity(location.getRaw(), EntityType.fromName(type)));
	}

	public RunsafeEntity spawnCreature(RunsafeLocation location, int id)
	{
		return ObjectWrapper.convert(world.spawnEntity(location.getRaw(), EntityType.fromId(id)));
	}

	public List<RunsafePlayer> getPlayers()
	{
		ArrayList<RunsafePlayer> result = new ArrayList<RunsafePlayer>();
		for (Player p : world.getPlayers())
			result.add(new RunsafePlayer(p));
		return result;
	}

	public List<RunsafeEntity> getEntities()
	{
		return ObjectWrapper.convert(world.getEntities());
	}

	private final World world;
}
