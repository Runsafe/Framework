package no.runsafe.framework.wrapper.entity;

import no.runsafe.framework.server.entity.RunsafeEntity;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Hanging;

public abstract class BukkitHanging extends RunsafeEntity
{
	public BukkitHanging(Hanging toWrap)
	{
		super(toWrap);
		hanging = toWrap;
	}

	public boolean setFacingDirection(BlockFace face, boolean force)
	{
		return hanging.setFacingDirection(face, force);
	}

	@Override
	public Hanging getRaw()
	{
		return hanging;
	}

	protected final Hanging hanging;
}
