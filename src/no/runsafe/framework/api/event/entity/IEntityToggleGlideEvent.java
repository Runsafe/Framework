package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityToggleGlideEvent;

public interface IEntityToggleGlideEvent extends IRunsafeEvent
{
	boolean OnEntityGlide(RunsafeEntityToggleGlideEvent event);
}
