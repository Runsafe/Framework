package no.runsafe.framework.server.inventory;

import no.runsafe.framework.server.ObjectWrapper;
import org.bukkit.inventory.Inventory;

public class RunsafeInventory
{
	public RunsafeInventory(Inventory toWrap)
	{
		inventory = toWrap;
	}

	public IInventoryHolder getHolder()
	{
		return ObjectWrapper.convert(inventory.getHolder());
	}

	public void clear()
	{
		inventory.clear();
	}

	private final Inventory inventory;
}
