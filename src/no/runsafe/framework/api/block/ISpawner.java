package no.runsafe.framework.api.block;

import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.minecraft.entity.LivingEntity;

public interface ISpawner
{
	void setCreature(LivingEntity type);
	RunsafeEntityType getCreature();
}
