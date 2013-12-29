package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.IWorldEffect;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class WorldBlockEffect implements IWorldEffect
{
	@SuppressWarnings("LocalVariableOfConcreteClass")
	public WorldBlockEffect(WorldBlockEffectType type, Item blockType)
	{
		RunsafeMeta item = blockType.getItem();
		name = type.getName() + item.getItemId() + '_' + item.getData().getData();
	}

	@Override
	public String getName()
	{
		return name;
	}

	private final String name;
}
