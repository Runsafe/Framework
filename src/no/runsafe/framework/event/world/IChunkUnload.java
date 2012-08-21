package no.runsafe.framework.event.world;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.chunk.RunsafeChunk;

public interface IChunkUnload extends IRunsafeEvent
{
	void OnChunkUnload(RunsafeChunk chunk);
}
