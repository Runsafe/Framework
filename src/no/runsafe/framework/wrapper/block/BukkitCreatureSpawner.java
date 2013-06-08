package no.runsafe.framework.wrapper.block;

import no.runsafe.framework.server.block.RunsafeBlockState;
import no.runsafe.framework.server.entity.RunsafeEntityType;
import org.bukkit.block.CreatureSpawner;

public abstract class BukkitCreatureSpawner extends RunsafeBlockState
{
	public BukkitCreatureSpawner(CreatureSpawner toWrap)
	{
		super(toWrap);
		spawner = toWrap;
	}

	@Deprecated
	public void setCreatureTypeByName(String s)
	{
		spawner.setCreatureTypeByName(s);
	}

	@Deprecated
	public String getCreatureTypeName()
	{
		return spawner.getCreatureTypeName();
	}

	public int getDelay()
	{
		return spawner.getDelay();
	}

	public void setDelay(int i)
	{
		spawner.setDelay(i);
	}

	public void SetCreature(RunsafeEntityType type)
	{
		spawner.setSpawnedType(type.getRaw());
	}

	public RunsafeEntityType GetCreature()
	{
		return no.runsafe.framework.server.entity.EntityType.convert(spawner.getSpawnedType());
	}

	@Override
	public CreatureSpawner getRaw()
	{
		return spawner;
	}

	protected final CreatureSpawner spawner;
}
