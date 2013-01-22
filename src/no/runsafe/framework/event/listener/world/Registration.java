package no.runsafe.framework.event.listener.world;

public final class Registration
{
	public static void Run()
	{
		ChunkLoad.Register();
		ChunkPopulate.Register();
		ChunkUnload.Register();
		SpawnChange.Register();
		WorldInit.Register();
		WorldLoad.Register();
		WorldSave.Register();
		WorldUnload.Register();
	}
}
