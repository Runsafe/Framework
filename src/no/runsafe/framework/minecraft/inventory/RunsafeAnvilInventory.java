package no.runsafe.framework.minecraft.inventory;

import no.runsafe.framework.internal.wrapper.inventory.BukkitAnvilInventory;
import org.bukkit.inventory.AnvilInventory;

public class RunsafeAnvilInventory extends BukkitAnvilInventory
{
	public RunsafeAnvilInventory(AnvilInventory inventory)
	{
		super(inventory);
	}
}
