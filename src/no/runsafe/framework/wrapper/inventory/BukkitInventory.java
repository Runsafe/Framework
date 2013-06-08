package no.runsafe.framework.wrapper.inventory;

import com.google.common.collect.Lists;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.server.material.RunsafeMaterial;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class BukkitInventory
{
	public BukkitInventory(Inventory toWrap)
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

	public void clear(int slot)
	{
		inventory.clear(slot);
	}

	public Inventory getRaw()
	{
		return this.inventory;
	}

	@Deprecated
	public boolean contains(int material)
	{
		return this.inventory.contains(material);
	}

	@Deprecated
	public boolean contains(int material, int amount)
	{
		return this.inventory.contains(material, amount);
	}

	public boolean contains(RunsafeItemStack itemStack)
	{
		return this.inventory.contains(itemStack.getRaw());
	}

	public boolean contains(RunsafeItemStack itemStack, int amount)
	{
		return this.inventory.contains(itemStack.getRaw(), amount);
	}

	@Deprecated
	public boolean contains(RunsafeMaterial material)
	{
		return this.inventory.contains(material.getRaw());
	}

	@Deprecated
	public boolean contains(RunsafeMaterial material, int amount)
	{
		return this.inventory.contains(material.getRaw(), amount);
	}

	public boolean contains(Item item)
	{
		return inventory.contains(item.getType());
	}

	public boolean contains(Item item, int amount)
	{
		return inventory.contains(item.getType(), amount);
	}

	public int first(int material)
	{
		return this.inventory.first(material);
	}

	public int first(RunsafeItemStack itemStack)
	{
		return this.inventory.first(itemStack.getRaw());
	}

	@Deprecated
	public int first(RunsafeMaterial material)
	{
		return this.inventory.first(material.getRaw());
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

	public void remove(RunsafeItemStack itemStack)
	{
		this.inventory.remove(itemStack.getRaw());
	}

	@Deprecated
	public void remove(RunsafeMaterial material)
	{
		this.inventory.remove(material.getRaw());
	}

	public void setItem(int index, RunsafeItemStack itemStack)
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
