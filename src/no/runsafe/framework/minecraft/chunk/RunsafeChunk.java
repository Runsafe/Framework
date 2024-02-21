package no.runsafe.framework.minecraft.chunk;

import no.runsafe.framework.api.chunk.IChunk;
import no.runsafe.framework.internal.wrapper.chunk.BukkitChunk;
import org.bukkit.Chunk;

public class RunsafeChunk extends BukkitChunk implements IChunk
{
	public RunsafeChunk(Chunk toWrap)
	{
		super(toWrap);
	}
}
