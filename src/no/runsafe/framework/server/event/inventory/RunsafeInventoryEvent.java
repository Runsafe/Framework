package no.runsafe.framework.server.event.inventory;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.event.RunsafeEvent;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import org.bukkit.event.inventory.InventoryEvent;

public class RunsafeInventoryEvent extends RunsafeEvent
{
	public RunsafeInventoryEvent(InventoryEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(this.event.getInventory());
	}

	// TODO: Implement getViewers();
	// TODO: Implement geView();

	private InventoryEvent event;
}
