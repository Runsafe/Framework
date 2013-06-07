package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.entity.LivingEntity;
import no.runsafe.framework.server.entity.RunsafeEntityType;
import org.bukkit.block.Block;

public class RunsafeSpawner extends RunsafeBlock
{
	public RunsafeSpawner(Block toWrap)
	{
		super(toWrap);
	}

	@Override
	public RunsafeCreatureSpawner getBlockState()
	{
		return (RunsafeCreatureSpawner) super.getBlockState();
	}

	@Deprecated
	public String getCreatureType()
	{
		return getBlockState().getCreatureTypeName();
	}

	@Deprecated
	public int getCreatureId()
	{
		return getBlockState().getRaw().getSpawnedType().getTypeId();
	}

	@Deprecated
	public void setCreatureType(String type)
	{
		getBlockState().setCreatureTypeByName(type);
	}

	public void setCreature(LivingEntity type)
	{
		getBlockState().getRaw().setSpawnedType(type.getRaw());
	}

	public RunsafeEntityType getCreature()
	{
		return ObjectWrapper.convert(getBlockState().getRaw().getSpawnedType());
	}
}
