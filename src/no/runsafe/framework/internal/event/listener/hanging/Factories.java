package no.runsafe.framework.internal.event.listener.hanging;

import no.runsafe.framework.internal.event.BukkitEventMapper;

public final class Factories
{
	private Factories()
	{
	}

	public static void Register()
	{
		BukkitEventMapper.Register(ItemFramePlace.Factory());
		BukkitEventMapper.Register(PaintingPlace.Factory());
	}
}
