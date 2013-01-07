package no.runsafe.framework.server.event;

public abstract class RunsafeInternalEvent implements IFakeAbleEvent
{
	@Override
	public boolean isFake()
	{
		return true;
	}
}
