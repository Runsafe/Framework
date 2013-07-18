package no.runsafe.framework.internal.event.listener.world;

import no.runsafe.framework.internal.event.EventEngine;

public final class Factories
{
	private Factories()
	{
	}

	public static void Register()
	{
		EventEngine.Register(ChunkLoad.Factory());
		EventEngine.Register(ChunkPopulate.Factory());
		EventEngine.Register(ChunkUnload.Factory());
		EventEngine.Register(SpawnChange.Factory());
		EventEngine.Register(WorldInit.Factory());
		EventEngine.Register(WorldLoad.Factory());
		EventEngine.Register(WorldSave.Factory());
		EventEngine.Register(WorldUnload.Factory());
	}
}
