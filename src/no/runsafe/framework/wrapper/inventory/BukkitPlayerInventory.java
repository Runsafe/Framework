package no.runsafe.framework.wrapper.inventory;

import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.server.item.RunsafeItemStack;
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

	public List<RunsafeItemStack> getArmorContents()
	{
		return RunsafeItemStack.convert(inventory.getArmorContents());
	}

	public RunsafeItemStack getHelmet()
	{
		return new RunsafeItemStack(inventory.getHelmet());
	}

	public RunsafeItemStack getChestplate()
	{
		return new RunsafeItemStack(inventory.getChestplate());
	}

	public RunsafeItemStack getLeggings()
	{
		return new RunsafeItemStack(inventory.getLeggings());
	}

	public RunsafeItemStack getBoots()
	{
		return new RunsafeItemStack(inventory.getBoots());
	}

	public void setArmorContents(List<RunsafeItemStack> itemStacks)
	{
		ItemStack[] stacks = new ItemStack[itemStacks.size()];
		for (int i = 0; i < itemStacks.size(); ++i)
			stacks[i] = itemStacks.get(i).getRaw();
		inventory.setArmorContents(stacks);
	}

	public void setHelmet(RunsafeItemStack itemStack)
	{
		inventory.setHelmet(itemStack.getRaw());
	}

	public void setChestplate(RunsafeItemStack itemStack)
	{
		inventory.setChestplate(itemStack.getRaw());
	}

	public void setLeggings(RunsafeItemStack itemStack)
	{
		inventory.setLeggings(itemStack.getRaw());
	}

	public void setBoots(RunsafeItemStack itemStack)
	{
		inventory.setBoots(itemStack.getRaw());
	}

	public RunsafeItemStack getItemInHand()
	{
		return new RunsafeItemStack(inventory.getItemInHand());
	}

	public void setItemInHand(RunsafeItemStack itemStack)
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
