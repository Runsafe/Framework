package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.minecraft.block.RunsafeBlockState;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import org.bukkit.block.CreatureSpawner;

public abstract class BukkitCreatureSpawner extends RunsafeBlockState
{
	public BukkitCreatureSpawner(CreatureSpawner toWrap)
	{
		super(toWrap);
		spawner = toWrap;
	}

	public int getDelay()
	{
		return spawner.getDelay();
	}

	public void setDelay(int i)
	{
		spawner.setDelay(i);
	}

	public void setCreature(RunsafeEntityType type)
	{
		spawner.setSpawnedType(type.getRaw());
	}

	public RunsafeEntityType getCreature()
	{
		return no.runsafe.framework.minecraft.entity.EntityType.convert(spawner.getSpawnedType());
	}

	@Override
	public CreatureSpawner getRaw()
	{
		return spawner;
	}

	protected final CreatureSpawner spawner;
}
