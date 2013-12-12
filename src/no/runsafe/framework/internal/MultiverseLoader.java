package no.runsafe.framework.internal;

import no.runsafe.framework.api.hook.IUniverseMapper;
import org.picocontainer.Startable;

public class MultiverseLoader implements Startable
{
	public MultiverseLoader()
	{
	}

	@SuppressWarnings("OverloadedVarargsMethod")
	public MultiverseLoader(Multiverse multiverse, IUniverseMapper... providers)
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
