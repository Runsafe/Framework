package no.runsafe.framework.minecraft.inventory;

import no.runsafe.framework.internal.wrapper.inventory.BukkitCraftingInventory;
import org.bukkit.inventory.CraftingInventory;

public class RunsafeCraftingInventory extends BukkitCraftingInventory
{
	public RunsafeCraftingInventory(CraftingInventory toWrap)
	{
		super(toWrap);
	}
}
