package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.internal.wrapper.entity.BukkitFallingBlock;
import org.bukkit.entity.FallingBlock;

public class RunsafeFallingBlock extends BukkitFallingBlock
{
	public RunsafeFallingBlock(FallingBlock toWrap)
	{
		super(toWrap);
	}

	public void setFallingBlockID(int fallingBlockID)
	{
		this.fallingBlockID = fallingBlockID;
	}

	public int getFallingBlockID()
	{
		return fallingBlockID;
	}

	private int fallingBlockID;
}
