package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.event.IRunsafeEvent;

public interface IEntityTeleport extends IRunsafeEvent
{
	boolean OnEntityTeleport(IEntity player, ILocation from, ILocation to);
}
