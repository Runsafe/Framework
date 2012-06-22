package no.runsafe.framework.server.inventory;

import org.bukkit.inventory.Inventory;

public class RunsafeInventory
{
	public RunsafeInventory(Inventory toWrap)
	{
		inventory = toWrap;
	}

	public void clear()
	{
		inventory.clear();
	}

	private final Inventory inventory;
}
