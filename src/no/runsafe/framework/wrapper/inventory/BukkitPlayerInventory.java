package no.runsafe.framework.wrapper.inventory;

import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.server.item.meta.RunsafeMeta;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

public abstract class BukkitPlayerInventory extends RunsafeInventory
{
	public BukkitPlayerInventory(PlayerInventory toWrap)
	{
		super(toWrap);
		inventory = toWrap;
	}

	public List<RunsafeMeta> getArmorContents()
	{
		return ObjectWrapper.convert(inventory.getArmorContents());
	}

	public RunsafeMeta getHelmet()
	{
		return ObjectWrapper.convert(inventory.getHelmet());
	}

	public RunsafeMeta getChestplate()
	{
		return ObjectWrapper.convert(inventory.getChestplate());
	}

	public RunsafeMeta getLeggings()
	{
		return ObjectWrapper.convert(inventory.getLeggings());
	}

	public RunsafeMeta getBoots()
	{
		return ObjectWrapper.convert(inventory.getBoots());
	}

	public void setArmorContents(List<RunsafeMeta> itemStacks)
	{
		ItemStack[] stacks = new ItemStack[itemStacks.size()];
		for (int i = 0; i < itemStacks.size(); ++i)
			stacks[i] = itemStacks.get(i).getRaw();
		inventory.setArmorContents(stacks);
	}

	public void setHelmet(RunsafeMeta itemStack)
	{
		inventory.setHelmet(itemStack.getRaw());
	}

	public void setChestplate(RunsafeMeta itemStack)
	{
		inventory.setChestplate(itemStack.getRaw());
	}

	public void setLeggings(RunsafeMeta itemStack)
	{
		inventory.setLeggings(itemStack.getRaw());
	}

	public void setBoots(RunsafeMeta itemStack)
	{
		inventory.setBoots(itemStack.getRaw());
	}

	public RunsafeMeta getItemInHand()
	{
		return ObjectWrapper.convert(inventory.getItemInHand());
	}

	public void setItemInHand(RunsafeMeta itemStack)
	{
		inventory.setItemInHand(itemStack.getRaw());
	}

	public int getHeldItemSlot()
	{
		return inventory.getHeldItemSlot();
	}

	public void clear()
	{
		super.clear();
		inventory.setArmorContents(new ItemStack[4]);
	}

	public PlayerInventory getRaw()
	{
		return inventory;
	}

	protected final PlayerInventory inventory;
}
