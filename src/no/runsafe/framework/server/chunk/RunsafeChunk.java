package no.runsafe.framework.server.chunk;

import no.runsafe.framework.wrapper.chunk.BukkitChunk;
import org.bukkit.Chunk;

public class RunsafeChunk extends BukkitChunk
{
	public RunsafeChunk(Chunk toWrap)
	{
		super(toWrap);
	}
}
