package no.runsafe.framework.minecraft.event;

import no.runsafe.framework.api.event.IFakeableEvent;

public abstract class RunsafeInternalEvent implements IFakeableEvent
{
	@Override
	public boolean isFake()
	{
		return true;
	}
}
