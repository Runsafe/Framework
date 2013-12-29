package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.IWorldEffect;

public class WorldBlockEffect implements IWorldEffect
{
	public WorldBlockEffect(WorldBlockEffectType type, Item blockType)
	{
		name = type.getName() + blockType.getItem().getItemId();
	}

	@Override
	public String getName()
	{
		return name;
	}

	private final String name;
}
