package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.EventEngine;

public final class Factories
{
	public static void Register()
	{
		EventEngine.Register(BlockBreak.Factory());
		EventEngine.Register(BlockBreakListener.Factory());
		EventEngine.Register(BlockDispense.Factory());
		EventEngine.Register(BlockPlace.Factory());
		EventEngine.Register(BlockRedstone.Factory());
		EventEngine.Register(SignChange.Factory());
	}
}
