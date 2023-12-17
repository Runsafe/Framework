package no.runsafe.framework.api.event.world;

import no.runsafe.framework.api.chunk.IChunk;
import no.runsafe.framework.api.event.IRunsafeEvent;

public interface IChunkUnload extends IRunsafeEvent
{
	/**
	 * Respond to a chunk being unloaded
	 *
	 * @param chunk The chunk that is being unloaded
	 * @return If not an async event, whether to allow the event
	 */
	boolean OnChunkUnload(IChunk chunk);
}
