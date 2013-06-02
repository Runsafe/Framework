package no.runsafe.framework.server.event.inventory;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.entity.RunsafeItem;
import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public class RunsafeInventoryPickupItemEvent implements CancellableEvent
{
	public RunsafeInventoryPickupItemEvent(InventoryPickupItemEvent toWrap)
	{
		this.event = toWrap;
	}

	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(this.event.getInventory());
	}

	public RunsafeItem getItem()
	{
		return ObjectWrapper.convert(this.event.getItem());
	}

	@Override
	public boolean getCancelled()
	{
		return this.event.isCancelled();
	}

	@Override
	public void setCancelled(boolean cancel)
	{
		this.event.setCancelled(cancel);
	}

	private final InventoryPickupItemEvent event;
}
