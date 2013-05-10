package no.runsafe.framework.event.listener.inventory;

import no.runsafe.framework.event.EventEngine;

public class Factories
{
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
	}
}
