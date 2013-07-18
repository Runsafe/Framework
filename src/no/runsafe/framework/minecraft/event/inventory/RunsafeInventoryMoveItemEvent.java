package no.runsafe.framework.minecraft.event.inventory;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.event.RunsafeCancellableEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class RunsafeInventoryMoveItemEvent extends RunsafeCancellableEvent
{
	public RunsafeInventoryMoveItemEvent(InventoryMoveItemEvent toWrap)
	{
		super(toWrap);
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

	public RunsafeMeta getItem()
	{
		return ObjectWrapper.convert(this.event.getItem());
	}

	public void setItem(RunsafeMeta item)
	{
		this.event.setItem(item.getRaw());
	}

	public RunsafeInventory getInitiator()
	{
		return ObjectWrapper.convert(this.event.getInitiator());
	}

	private final InventoryMoveItemEvent event;
}
