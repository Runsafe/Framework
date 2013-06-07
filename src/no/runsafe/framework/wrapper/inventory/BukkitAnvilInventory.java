package no.runsafe.framework.wrapper.inventory;

import no.runsafe.framework.server.inventory.RunsafeInventory;
import org.bukkit.inventory.AnvilInventory;

public class BukkitAnvilInventory extends RunsafeInventory
{
	public BukkitAnvilInventory(AnvilInventory inventory)
	{
		super(inventory);
		this.inventory = inventory;
	}

	public AnvilInventory getRaw()
	{
		return this.inventory;
	}

	protected final AnvilInventory inventory;
}
