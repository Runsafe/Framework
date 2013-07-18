package no.runsafe.framework.minecraft.event.inventory;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeItem;
import no.runsafe.framework.minecraft.event.RunsafeCancellableEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public class RunsafeInventoryPickupItemEvent extends RunsafeCancellableEvent
{
	public RunsafeInventoryPickupItemEvent(InventoryPickupItemEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(event.getInventory());
	}

	public RunsafeItem getItem()
	{
		return ObjectWrapper.convert(event.getItem());
	}

	private final InventoryPickupItemEvent event;
}
