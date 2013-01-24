package no.runsafe.framework.server.block;

import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;

public class RunsafeCreatureSpawner extends RunsafeBlockState
{
	public RunsafeCreatureSpawner(CreatureSpawner toWrap)
	{
		super(toWrap);
		spawner = toWrap;
	}

	public void setCreatureTypeByName(String s)
	{
		spawner.setCreatureTypeByName(s);
	}

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

	@Override
	public CreatureSpawner getRaw()
	{
		return spawner;
	}

	private final CreatureSpawner spawner;
}
