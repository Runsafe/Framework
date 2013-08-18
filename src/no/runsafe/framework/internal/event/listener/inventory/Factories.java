package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.internal.event.EventEngine;

public final class Factories
{
	private Factories()
	{
	}

	public static void Register()
	{
		EventEngine.Register(ChestClose.Factory());
		EventEngine.Register(ChestOpen.Factory());
		EventEngine.Register(InventoryClose.Factory());
		EventEngine.Register(InventoryOpen.Factory());
		EventEngine.Register(Inventory.Factory());
		EventEngine.Register(InventoryClick.Factory());
		EventEngine.Register(InventoryMoveItem.Factory());
		EventEngine.Register(InventoryPickupItem.Factory());
		EventEngine.Register(CraftItem.Factory());
	}
}
