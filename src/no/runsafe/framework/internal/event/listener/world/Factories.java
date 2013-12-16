package no.runsafe.framework.internal.event.listener.world;

import no.runsafe.framework.internal.event.BukkitEventMapper;

public final class Factories
{
	private Factories()
	{
	}

	public static void Register()
	{
		BukkitEventMapper.Register(ChunkLoad.Factory());
		BukkitEventMapper.Register(ChunkPopulate.Factory());
		BukkitEventMapper.Register(ChunkUnload.Factory());
		BukkitEventMapper.Register(SpawnChange.Factory());
		BukkitEventMapper.Register(Init.Factory());
		BukkitEventMapper.Register(Load.Factory());
		BukkitEventMapper.Register(Save.Factory());
		BukkitEventMapper.Register(Unload.Factory());
	}
}
