package no.runsafe.framework.minecraft.chunk;

import no.runsafe.framework.internal.wrapper.chunk.BukkitChunk;
import org.bukkit.Chunk;

public class RunsafeChunk extends BukkitChunk
{
	public RunsafeChunk(Chunk toWrap)
	{
		super(toWrap);
	}
}
