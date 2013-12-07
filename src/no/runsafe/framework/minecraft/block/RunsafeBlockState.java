package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.IBlockState;
import no.runsafe.framework.internal.wrapper.block.BukkitBlockState;
import org.bukkit.block.BlockState;

public class RunsafeBlockState extends BukkitBlockState implements IBlockState
{
	public RunsafeBlockState(BlockState toWrap)
	{
		super(toWrap);
	}
}
