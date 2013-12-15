package no.runsafe.framework.features;

import no.runsafe.framework.api.hook.IUniverseMapper;
import no.runsafe.framework.internal.Multiverse;
import org.picocontainer.Startable;

public final class UniverseRegistration implements Startable
{
	public UniverseRegistration()
	{
	}

	@SuppressWarnings("OverloadedVarargsMethod")
	public UniverseRegistration(Multiverse multiverse, IUniverseMapper... providers)
	{
		for (IUniverseMapper mapper : providers)
			multiverse.addUniversesForMapper(mapper);
	}


	@Override
	public void start()
	{
	}

	@Override
	public void stop()
	{
	}
}
