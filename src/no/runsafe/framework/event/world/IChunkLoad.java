package no.runsafe.framework.event.world;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.chunk.RunsafeChunk;

public interface IChunkLoad extends IRunsafeEvent
{
	void OnChunkLoad(RunsafeChunk chunk);
}

