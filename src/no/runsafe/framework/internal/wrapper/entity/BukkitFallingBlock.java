package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.internal.LegacyMaterial;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.entity.FallingBlock;

public abstract class BukkitFallingBlock extends RunsafeEntity
{
	protected BukkitFallingBlock(FallingBlock toWrap)
	{
		super(toWrap);
		block = toWrap;
	}

	public Byte getBlockData()
	{
		return block.getBlockData();
	}

	public int getBlockId()
	{
		return LegacyMaterial.getIdOf(block.getMaterial());
	}

	public boolean getDropItem()
	{
		return block.getDropItem();
	}

	public void setDropItem(boolean drop)
	{
		block.setDropItem(drop);
	}

	@Override
	public FallingBlock getRaw()
	{
		return block;
	}

	protected final FallingBlock block;
}
