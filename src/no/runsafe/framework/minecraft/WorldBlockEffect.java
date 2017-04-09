package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.IWorldEffect;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class WorldBlockEffect implements IWorldEffect
{
	@SuppressWarnings("LocalVariableOfConcreteClass")
	public WorldBlockEffect(WorldBlockEffectType type, Item blockType)
	{
		RunsafeMeta item = blockType.getItem();
		name = type.getName();
		blockID = item.getItemId();
		blockData = item.getData().getData();
	}

	@Override
	public String getName()
	{
		return name;
	}

	public int getBlockID()
	{
		return blockID;
	}

	public int getBlockData()
	{
		return blockData;
	}

	private final String name;
	private final int blockID;
	private final int blockData;
}
