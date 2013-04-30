package no.runsafe.framework.event.entity;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.entity.RunsafeLivingEntity;
import no.runsafe.framework.server.material.RunsafeMaterial;

public interface IEntityChangeBlockEvent extends IRunsafeEvent
{
	public void OnEntityChangeBlockEvent(RunsafeLivingEntity entity, RunsafeBlock block, RunsafeMaterial material);
}
