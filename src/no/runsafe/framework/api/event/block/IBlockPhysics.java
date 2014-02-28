package no.runsafe.framework.api.event.block;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.block.RunsafeBlockPhysicsEvent;

public interface IBlockPhysics extends IRunsafeEvent
{
	void OnBlockPhysics(RunsafeBlockPhysicsEvent event);
}
