package no.runsafe.framework.api.item.data;

import no.runsafe.framework.api.minecraft.RunsafeEntityType;

public interface ISpawnEggData extends IItemData
{
	RunsafeEntityType getSpawnedType();
	void setSpawnedType(RunsafeEntityType type);
}
