package no.runsafe.framework.minecraft;

import net.minecraft.server.v1_12_R1.EnumParticle;
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
		block = blockType;
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

	@Deprecated
	public int getBlockID()
	{
		return block.getItemID();
	}
	public RunsafeMeta getBlock()
	{
		return block.getItem();
	}

	public int getBlockData()
	{
		return blockData;
	}

	private final EnumParticle particle;
	private final String name;
	private final Item block;
	private final int blockData;
}
