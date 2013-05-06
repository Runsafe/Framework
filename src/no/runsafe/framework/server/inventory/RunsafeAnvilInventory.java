package no.runsafe.framework.server.inventory;

import org.bukkit.inventory.AnvilInventory;

public class RunsafeAnvilInventory extends RunsafeInventory
{
	public RunsafeAnvilInventory(AnvilInventory inventory)
	{
		super(inventory);
		this.inventory = inventory;
	}

	public AnvilInventory getRaw()
	{
		return this.inventory;
	}

	private AnvilInventory inventory;
}
