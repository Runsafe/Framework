package no.runsafe.framework.server.entity;

import no.runsafe.framework.wrapper.entity.BukkitFallingBlock;
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
		return this.fallingBlockID;
	}

	private int fallingBlockID;
}
