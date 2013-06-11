package no.runsafe.framework.minecraft.event.inventory;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeItem;
import no.runsafe.framework.api.event.CancellableEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
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
