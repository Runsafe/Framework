package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.block.BukkitBlockState;
import org.bukkit.block.BlockState;

public class RunsafeBlockState extends BukkitBlockState
{
	public RunsafeBlockState(BlockState toWrap)
	{
		super(toWrap);
	}
}
