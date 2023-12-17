package no.runsafe.framework.api.block;

import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.minecraft.entity.LivingEntity;

public interface ICreatureSpawner extends IBlockState, IBlock
{
	void setCreature(LivingEntity type);
	void setCreature(RunsafeEntityType type);
	RunsafeEntityType getCreature();
	int getDelay();
	void setDelay(int delay);
}
