package no.runsafe.framework.minecraft.inventory;

import no.runsafe.framework.internal.wrapper.inventory.BukkitDoubleChestInventory;
import org.bukkit.inventory.DoubleChestInventory;

public class RunsafeDoubleChestInventory extends BukkitDoubleChestInventory
{
	public RunsafeDoubleChestInventory(DoubleChestInventory toWrap)
	{
		super(toWrap);
	}
}
