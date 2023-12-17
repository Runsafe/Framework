package no.runsafe.framework.api.player;

import no.runsafe.framework.api.IUniverse;

import javax.annotation.Nullable;

public interface IPlayerUniverse
{
	@Nullable
	IUniverse getUniverse();
	boolean isInUniverse(String universeName);
	String getWorldName();
}
