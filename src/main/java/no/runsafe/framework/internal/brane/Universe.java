package no.runsafe.framework.internal.brane;

import no.runsafe.framework.api.IUniverse;
import no.runsafe.framework.api.hook.IUniverseMapper;

import javax.annotation.Nonnull;

public class Universe implements IUniverse
{
	public Universe(String name, IUniverseMapper mapper)
	{
		this.name = name;
		this.mapper = mapper;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	@Nonnull
	public Iterable<String> getWorlds()
	{
		return mapper.GetWorlds(name);
	}

	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof IUniverse && ((IUniverse) obj).getName().equals(name);
	}

	@Override
	public int hashCode()
	{
		return name.hashCode();
	}

	private final String name;
	private final IUniverseMapper mapper;
}
