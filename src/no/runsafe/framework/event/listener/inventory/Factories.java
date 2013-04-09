package no.runsafe.framework.event.listener.inventory;

import no.runsafe.framework.event.EventEngine;

public class Factories
{
	public static void Register()
	{
		EventEngine.Register(InventoryClose.Factory());
		EventEngine.Register(InventoryOpen.Factory());
	}
}
