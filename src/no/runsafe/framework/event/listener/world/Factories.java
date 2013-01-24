package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.EventEngine;

public final class Factories
{
	public static void Register() throws InstantiationException, IllegalAccessException
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
