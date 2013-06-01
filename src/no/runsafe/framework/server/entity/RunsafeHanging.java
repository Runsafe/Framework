package no.runsafe.framework.server.entity;

import org.bukkit.block.BlockFace;
import org.bukkit.entity.Hanging;

public class RunsafeHanging extends RunsafeEntity
{
	public RunsafeHanging(Hanging toWrap)
	{
		super(toWrap);
		hanging = toWrap;
	}

	public boolean setFacingDirection(BlockFace face, boolean force)
	{
		return hanging.setFacingDirection(face, force);
	}

	private final Hanging hanging;
}
