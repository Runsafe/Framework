package no.runsafe.framework.server.chunk;

import org.bukkit.Chunk;

public class RunsafeChunk
{
    public RunsafeChunk(Chunk toWrap)
    {
        chunk = toWrap;
    }

    private Chunk chunk;
}
