package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.RunsafeWorld;
import no.runsafe.framework.server.chunk.RunsafeChunk;
import no.runsafe.framework.server.material.RunsafeMaterial;
import no.runsafe.framework.server.material.RunsafeMaterialData;
import no.runsafe.framework.wrapper.block.BukkitBlockState;
import org.bukkit.block.BlockState;

public class RunsafeBlockState extends BukkitBlockState
{
	public RunsafeBlockState(BlockState toWrap)
	{
		super(toWrap);
	}
}
