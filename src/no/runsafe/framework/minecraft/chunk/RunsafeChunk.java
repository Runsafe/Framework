package no.runsafe.framework.minecraft.chunk;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.chunk.IChunk;
import no.runsafe.framework.internal.wrapper.chunk.BukkitChunk;
import org.bukkit.Chunk;

public class RunsafeChunk extends BukkitChunk implements IChunk
{
	public RunsafeChunk(Chunk toWrap)
	{
		super(toWrap);
	}

	@Override
	public boolean locationIsInChunk(ILocation location)
	{
		if (!location.getWorld().isWorld(getWorld()))
			return false;

		double startX = getX() * 16;
		double startZ = getZ() * 16;
		double endX = startX + 16;
		double endZ = startZ + 16;

		double blockX = location.getBlockX();
		double blockZ = location.getBlockZ();

		return (blockX >= startX && blockX <= endX && blockZ >= startZ && blockZ <= endZ);
	}
}
