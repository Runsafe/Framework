package no.runsafe.framework.minecraft;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.IUniverse;

import javax.annotation.Nonnull;

public class DefaultUniverse implements IUniverse
{
	public DefaultUniverse(String name)
	{
		worldName = name;
	}

	public String getName()
	{
		return worldName;
	}

	@Nonnull
	public Iterable<String> getWorlds()
	{
		return Lists.newArrayList(worldName);
	}

	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof IUniverse && ((IUniverse) obj).getName().equals(worldName);
	}

	@Override
	public int hashCode()
	{
		return worldName.hashCode();
	}

	private final String worldName;
}
