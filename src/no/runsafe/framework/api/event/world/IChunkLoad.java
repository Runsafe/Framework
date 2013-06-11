package no.runsafe.framework.api.event.world;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.chunk.RunsafeChunk;

public interface IChunkLoad extends IRunsafeEvent
{
	void OnChunkLoad(RunsafeChunk chunk);
}

