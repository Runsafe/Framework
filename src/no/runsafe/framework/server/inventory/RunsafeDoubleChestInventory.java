package no.runsafe.framework.server.inventory;

import no.runsafe.framework.wrapper.inventory.BukkitDoubleChestInventory;
import org.bukkit.inventory.DoubleChestInventory;

public class RunsafeDoubleChestInventory extends BukkitDoubleChestInventory
{
	public RunsafeDoubleChestInventory(DoubleChestInventory toWrap)
	{
		super(toWrap);
	}
}
