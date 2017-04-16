package no.runsafe.framework.minecraft;

import net.minecraft.server.v1_8_R3.EnumParticle;
import no.runsafe.framework.api.IWorldEffect;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

public class WorldBlockEffect implements IWorldEffect
{
	@SuppressWarnings("LocalVariableOfConcreteClass")
	public WorldBlockEffect(WorldBlockEffectType type, Item blockType)
	{
		RunsafeMeta item = blockType.getItem();
		particle = type.getBukkitParticle();
		name = type.getName();
		blockID = item.getItemId();
		blockData = item.getData().getData();
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public EnumParticle getBukkitParticle()
	{
		return particle;
	}

	public int getBlockID()
	{
		return blockID;
	}

	public int getBlockData()
	{
		return blockData;
	}

	private final EnumParticle particle;
	private final String name;
	private final int blockID;
	private final int blockData;
}
