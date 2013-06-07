package no.runsafe.framework.server.inventory;

import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.inventory.InventoryHolder;

public class RunsafeInventoryHolder
{
	public RunsafeInventoryHolder(InventoryHolder toWrap)
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
