package no.runsafe.framework.features;

import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.hook.IUniverseMapper;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.Multiverse;
import org.picocontainer.Startable;

import java.util.List;

public final class UniverseRegistration implements Startable
{
	@SuppressWarnings("OverloadedVarargsMethod")
	public UniverseRegistration(IConsole console, Multiverse multiverse, IKernel kernel)
	{
		this.console = console;
		this.multiverse = multiverse;
		this.kernel = kernel;
	}


	@Override
	public void start()
	{
		List<IUniverseMapper> mappers = kernel.getComponents(IUniverseMapper.class);
		if (mappers.isEmpty())
			console.logError("The plugin has declared it provides universe mapping, but there are no mappers defined!");
		for (IUniverseMapper mapper : mappers)
			multiverse.addUniversesForMapper(mapper);
	}

	@Override
	public void stop()
	{
	}

	private final IConsole console;
	private final Multiverse multiverse;
	private final IKernel kernel;
}
