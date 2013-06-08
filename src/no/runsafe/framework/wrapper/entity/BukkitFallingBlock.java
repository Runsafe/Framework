package no.runsafe.framework.wrapper.entity;

import no.runsafe.framework.server.entity.RunsafeEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;

public abstract class BukkitFallingBlock extends RunsafeEntity
{
	public BukkitFallingBlock(FallingBlock toWrap)
	{
		super(toWrap);
		this.block = toWrap;
	}

	public Byte getBlockData()
	{
		return this.block.getBlockData();
	}

	public int getBlockId()
	{
		return this.block.getBlockId();
	}

	public boolean getDropItem()
	{
		return this.block.getDropItem();
	}

	public void setDropItem(boolean drop)
	{
		this.block.setDropItem(drop);
	}

	@Override
	public FallingBlock getRaw()
	{
		return block;
	}

	protected final FallingBlock block;
}
