package no.runsafe.framework.internal.loader;

import no.runsafe.framework.api.hook.IUniverseMapper;
import no.runsafe.framework.internal.Multiverse;
import org.picocontainer.Startable;

public final class MultiverseLoader implements Startable
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
