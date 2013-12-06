package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import org.bukkit.block.Block;

public class RunsafeSpawner extends RunsafeBlock
{
	public RunsafeSpawner(Block toWrap)
	{
		super(toWrap);
	}

	@SuppressWarnings("CastToConcreteClass")
	@Override
	public RunsafeCreatureSpawner getBlockState()
	{
		return (RunsafeCreatureSpawner) super.getBlockState();
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
