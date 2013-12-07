package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.ICreatureSpawner;
import no.runsafe.framework.api.block.ISpawner;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.minecraft.entity.LivingEntity;
import org.bukkit.block.Block;

public class RunsafeSpawner extends RunsafeBlock implements ISpawner
{
	public RunsafeSpawner(Block toWrap)
	{
		super(toWrap);
	}

	@Override
	public ICreatureSpawner getBlockState()
	{
		return (ICreatureSpawner) super.getBlockState();
	}

	@Override
	public void setCreature(LivingEntity type)
	{
		getBlockState().setCreature(type);
	}

	@Override
	public RunsafeEntityType getCreature()
	{
		return getBlockState().getCreature();
	}
}
