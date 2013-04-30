package no.runsafe.framework.server.entity;

import org.bukkit.entity.FallingBlock;

public class RunsafeFallingBlock extends RunsafeEntity
{
	public RunsafeFallingBlock(FallingBlock toWrap)
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

	public void setFallingBlockID(int fallingBlockID)
	{
		this.fallingBlockID = fallingBlockID;
	}

	public int getFallingBlockID()
	{
		return this.fallingBlockID;
	}

	private final FallingBlock block;
	private int fallingBlockID;
}
