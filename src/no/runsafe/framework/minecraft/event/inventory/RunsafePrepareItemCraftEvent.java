package no.runsafe.framework.minecraft.event.inventory;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.inventory.RunsafeCraftingInventory;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;

public class RunsafePrepareItemCraftEvent extends RunsafeInventoryEvent
{
	public RunsafePrepareItemCraftEvent(PrepareItemCraftEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeCraftingInventory getInventory()
	{
		return (RunsafeCraftingInventory) ObjectWrapper.convert(event.getInventory());
	}

	boolean isRepair()
	{
		return event.isRepair();
	}

	private final PrepareItemCraftEvent event;
}
