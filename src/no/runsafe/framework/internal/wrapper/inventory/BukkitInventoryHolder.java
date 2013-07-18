package no.runsafe.framework.internal.wrapper.inventory;

import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.inventory.InventoryHolder;

public abstract class BukkitInventoryHolder
{
	protected BukkitInventoryHolder(InventoryHolder toWrap)
	{
		inventoryHolder = toWrap;
	}

	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(inventoryHolder.getInventory());
	}

	public InventoryHolder getRaw()
	{
		return inventoryHolder;
	}

	private final InventoryHolder inventoryHolder;
}
