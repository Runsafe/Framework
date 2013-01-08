package no.runsafe.framework.server.event;

public abstract class RunsafeInternalEvent implements IFakeableEvent
{
	@Override
	public boolean isFake()
	{
		return true;
	}
}
