package no.runsafe.framework.server.inventory;

import com.google.common.collect.Lists;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class RunsafeInventory
{
	public RunsafeInventory(Inventory toWrap)
	{
		inventory = toWrap;
	}

	public IInventoryHolder getHolder()
	{
		return ObjectWrapper.convert(inventory.getHolder());
	}

	public List<RunsafeItemStack> getContents()
	{
		return ObjectWrapper.convert(Lists.newArrayList(inventory.getContents()));
	}

	public void addItems(RunsafeItemStack... items)
	{
		if (items == null || items.length < 1)
			return;
		ItemStack[] itemStacks = new ItemStack[items.length];
		for (int i = 0; i < items.length; ++i)
			itemStacks[i] = items[i].getRaw();
		inventory.addItem(itemStacks);
	}

	public void clear()
	{
		inventory.clear();
	}

	public Inventory getRaw()
	{
		return this.inventory;
	}

	private final Inventory inventory;
}
