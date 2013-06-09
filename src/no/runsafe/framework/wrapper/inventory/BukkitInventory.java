package no.runsafe.framework.wrapper.inventory;

import com.google.common.collect.Lists;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.item.meta.RunsafeMeta;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@SuppressWarnings("deprecation")
public abstract class BukkitInventory
{
	public BukkitInventory(Inventory toWrap)
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
		return this.inventory;
	}

	public boolean contains(RunsafeMeta itemStack)
	{
		return this.inventory.contains(itemStack.getRaw());
	}

	public boolean contains(RunsafeMeta itemStack, int amount)
	{
		return this.inventory.contains(itemStack.getRaw(), amount);
	}

	public boolean contains(Item item)
	{
		return inventory.contains(item.getType());
	}

	public boolean contains(Item item, int amount)
	{
		return inventory.contains(item.getType(), amount);
	}

	@Deprecated
	public int first(int material)
	{
		return this.inventory.first(material);
	}

	public int first(RunsafeMeta itemStack)
	{
		return this.inventory.first(itemStack.getRaw());
	}

	public int first(Item material)
	{
		return this.inventory.first(material.getType());
	}

	public int firstEmpty()
	{
		return this.inventory.firstEmpty();
	}

	public int getMaxStackSize()
	{
		return this.inventory.getMaxStackSize();
	}

	public String getName()
	{
		return this.inventory.getName();
	}

	public String getTitle()
	{
		return this.inventory.getTitle();
	}

	public int getSize()
	{
		return this.inventory.getSize();
	}

	@Deprecated
	public void remove(int material)
	{
		this.inventory.remove(material);
	}

	public void remove(RunsafeMeta itemStack)
	{
		this.inventory.remove(itemStack.getRaw());
	}

	public void remove(Item material)
	{
		this.inventory.remove(material.getType());
	}

	public void setItem(int index, RunsafeMeta itemStack)
	{
		this.inventory.setItem(index, itemStack.getRaw());
	}

	public void setMaxStackSize(int size)
	{
		this.inventory.setMaxStackSize(size);
	}

	public List<RunsafePlayer> getViewers()
	{
		return ObjectWrapper.convert(this.inventory.getViewers());
	}

	protected final Inventory inventory;
}
