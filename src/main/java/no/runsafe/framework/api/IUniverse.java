package no.runsafe.framework.api;

import javax.annotation.Nonnull;

public interface IUniverse
{
	String getName();

	@Nonnull
	Iterable<String> getWorlds();
}
