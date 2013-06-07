package no.runsafe.framework.wrapper.inventory;

import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.inventory.InventoryHolder;

public class BukkitInventoryHolder
{
	public BukkitInventoryHolder(InventoryHolder toWrap)
	{
		this.inventoryHolder = toWrap;
	}

	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(inventoryHolder.getInventory());
	}

	public InventoryHolder getRaw()
	{
		return this.inventoryHolder;
	}

	private final InventoryHolder inventoryHolder;
}
