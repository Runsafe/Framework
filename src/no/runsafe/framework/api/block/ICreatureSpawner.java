package no.runsafe.framework.api.block;

import no.runsafe.framework.api.minecraft.RunsafeEntityType;

public interface ICreatureSpawner extends IBlockState
{
	int getDelay();
	void setDelay(int delay);
	void setCreature(RunsafeEntityType type);
	RunsafeEntityType getCreature();
}
