package no.runsafe.framework.server.inventory;

import no.runsafe.framework.wrapper.inventory.BukkitAnvilInventory;
import org.bukkit.inventory.AnvilInventory;

public class RunsafeAnvilInventory extends BukkitAnvilInventory
{
	public RunsafeAnvilInventory(AnvilInventory inventory)
	{
		super(inventory);
	}
}
