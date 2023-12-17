package no.runsafe.framework.internal.wrapper.inventory;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryType;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public abstract class BukkitInventory
{
	protected BukkitInventory(Inventory toWrap)
	{
		inventory = toWrap;
	}

	public IInventoryHolder getHolder()
	{
		return ObjectWrapper.convert(inventory.getHolder());
	}

	public List<RunsafeMeta> getContents()
	{
		return ObjectWrapper.convert(Lists.newArrayList(inventory.getContents()));
	}

	public void addItems(RunsafeMeta... items)
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

	public void clear(int slot)
	{
		inventory.clear(slot);
	}

	public Inventory getRaw()
	{
		return inventory;
	}

	public boolean contains(RunsafeMeta itemStack)
	{
		return inventory.contains(itemStack.getRaw());
	}

	public boolean contains(RunsafeMeta itemStack, int amount)
	{
		return inventory.contains(itemStack.getRaw(), amount);
	}

	public boolean contains(Item item)
	{
		return inventory.contains(item.getType());
	}

	public boolean contains(Item item, int amount)
	{
		return inventory.contains(item.getType(), amount);
	}

	public int first(RunsafeMeta itemStack)
	{
		return inventory.first(itemStack.getRaw());
	}

	public int first(Item material)
	{
		return inventory.first(material.getType());
	}

	public int firstEmpty()
	{
		return inventory.firstEmpty();
	}

	public int getMaxStackSize()
	{
		return inventory.getMaxStackSize();
	}

	public String getName()
	{
		return inventory.getName();
	}

	public String getTitle()
	{
		return inventory.getTitle();
	}

	public int getSize()
	{
		return inventory.getSize();
	}

	public void remove(RunsafeMeta itemStack)
	{
		inventory.remove(itemStack.getRaw());
	}

	public void remove(Item material)
	{
		inventory.remove(material.getType());
	}

	public void setItem(int index, RunsafeMeta itemStack)
	{
		inventory.setItem(index, itemStack.getRaw());
	}

	public void setMaxStackSize(int size)
	{
		inventory.setMaxStackSize(size);
	}

	public List<IPlayer> getViewers()
	{
		return ObjectWrapper.convert(inventory.getViewers());
	}

	public RunsafeInventoryType getType()
	{
		return ObjectWrapper.convert(inventory.getType());
	}

	protected final Inventory inventory;
}
