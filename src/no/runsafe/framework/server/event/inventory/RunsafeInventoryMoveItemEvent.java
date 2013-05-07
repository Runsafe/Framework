package no.runsafe.framework.server.event.inventory;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class RunsafeInventoryMoveItemEvent implements CancellableEvent
{
	public RunsafeInventoryMoveItemEvent(InventoryMoveItemEvent toWrap)
	{
		this.event = toWrap;
	}

	public RunsafeInventory getSource()
	{
		return ObjectWrapper.convert(this.event.getSource());
	}

	public RunsafeInventory getDestination()
	{
		return ObjectWrapper.convert(this.event.getDestination());
	}

	public RunsafeItemStack getItem()
	{
		return ObjectWrapper.convert(this.event.getItem());
	}

	public void setItem(RunsafeItemStack item)
	{
		this.event.setItem(item.getRaw());
	}

	public RunsafeInventory getInitiator()
	{
		return ObjectWrapper.convert(this.event.getInitiator());
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

	private InventoryMoveItemEvent event;
}
