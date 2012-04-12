package no.runsafe.framework.item;

import org.bukkit.inventory.ItemStack;

public class RunsafeItemStack
{
	public RunsafeItemStack(ItemStack stack)
	{
		itemStack = stack;
	}

	public ItemStack getRaw()
	{
		return itemStack;
	}

	private ItemStack itemStack;
}
