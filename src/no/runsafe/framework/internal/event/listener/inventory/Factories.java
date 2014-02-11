package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.internal.event.BukkitEventMapper;

public final class Factories
{
	private Factories()
	{
	}

	public static void Register()
	{
		BukkitEventMapper.Register(ChestClose.Factory());
		BukkitEventMapper.Register(ChestOpen.Factory());
		BukkitEventMapper.Register(Close.Factory());
		BukkitEventMapper.Register(Open.Factory());
		BukkitEventMapper.Register(Inventory.Factory());
		BukkitEventMapper.Register(Click.Factory());
		BukkitEventMapper.Register(MoveItem.Factory());
		BukkitEventMapper.Register(PickupItem.Factory());
		BukkitEventMapper.Register(CraftItem.Factory());
		BukkitEventMapper.Register(PrepareCraftItem.Factory());
	}
}
