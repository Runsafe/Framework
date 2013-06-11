package no.runsafe.framework.api.event.world;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.chunk.RunsafeChunk;

public interface IChunkUnload extends IRunsafeEvent
{
	/**
	 * Respond to a chunk being unloaded
	 *
	 * @param chunk The chunk that is being unloaded
	 * @return If not an async event, whether to allow the event
	 */
	boolean OnChunkUnload(RunsafeChunk chunk);
}
