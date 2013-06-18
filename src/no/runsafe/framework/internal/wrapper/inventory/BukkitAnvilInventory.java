package no.runsafe.framework.internal.wrapper.inventory;

import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import org.bukkit.inventory.AnvilInventory;

public abstract class BukkitAnvilInventory extends RunsafeInventory
{
	protected BukkitAnvilInventory(AnvilInventory inventory)
	{
		super(inventory);
		this.inventory = inventory;
	}

	@Override
	public AnvilInventory getRaw()
	{
		return this.inventory;
	}

	protected final AnvilInventory inventory;
}
