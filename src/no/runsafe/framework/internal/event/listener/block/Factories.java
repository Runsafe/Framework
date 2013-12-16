package no.runsafe.framework.internal.event.listener.block;

import no.runsafe.framework.internal.event.BukkitEventMapper;

public final class Factories
{
	private Factories()
	{
	}

	public static void Register()
	{
		BukkitEventMapper.Register(Break.Factory());
		BukkitEventMapper.Register(BreakListener.Factory());
		BukkitEventMapper.Register(Dispense.Factory());
		BukkitEventMapper.Register(Place.Factory());
		BukkitEventMapper.Register(Redstone.Factory());
		BukkitEventMapper.Register(ChestBreak.Factory());
		BukkitEventMapper.Register(SignChange.Factory());
	}
}
