package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.EventEngine;

public final class Registration
{
	public static void Run()
	{
		EventEngine.Register(ChunkLoad.Factory.class);
		EventEngine.Register(ChunkPopulate.Factory.class);
		EventEngine.Register(ChunkUnload.Factory.class);
		EventEngine.Register(SpawnChange.Factory.class);
		EventEngine.Register(WorldInit.Factory.class);
		EventEngine.Register(WorldLoad.Factory.class);
		EventEngine.Register(WorldSave.Factory.class);
		EventEngine.Register(WorldUnload.Factory.class);
	}
}
