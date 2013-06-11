package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitBlockState;
import org.bukkit.block.BlockState;

public class RunsafeBlockState extends BukkitBlockState
{
	public RunsafeBlockState(BlockState toWrap)
	{
		super(toWrap);
	}
}
