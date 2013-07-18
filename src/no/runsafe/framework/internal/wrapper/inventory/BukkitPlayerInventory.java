package no.runsafe.framework.internal.wrapper.inventory;

import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

public abstract class BukkitPlayerInventory extends RunsafeInventory
{
	protected BukkitPlayerInventory(PlayerInventory toWrap)
	{
		super(toWrap);
		playerInventory = toWrap;
	}

	public List<RunsafeMeta> getArmorContents()
	{
		return ObjectWrapper.convert(playerInventory.getArmorContents());
	}

	public RunsafeMeta getHelmet()
	{
		return ObjectWrapper.convert(playerInventory.getHelmet());
	}

	public RunsafeMeta getChestplate()
	{
		return ObjectWrapper.convert(playerInventory.getChestplate());
	}

	public RunsafeMeta getLeggings()
	{
		return ObjectWrapper.convert(playerInventory.getLeggings());
	}

	public RunsafeMeta getBoots()
	{
		return ObjectWrapper.convert(playerInventory.getBoots());
	}

	public void setArmorContents(List<RunsafeMeta> itemStacks)
	{
		ItemStack[] stacks = new ItemStack[itemStacks.size()];
		for (int i = 0; i < itemStacks.size(); ++i)
			stacks[i] = itemStacks.get(i).getRaw();
		playerInventory.setArmorContents(stacks);
	}

	public void setHelmet(RunsafeMeta itemStack)
	{
		playerInventory.setHelmet(itemStack.getRaw());
	}

	public void setChestplate(RunsafeMeta itemStack)
	{
		playerInventory.setChestplate(itemStack.getRaw());
	}

	public void setLeggings(RunsafeMeta itemStack)
	{
		playerInventory.setLeggings(itemStack.getRaw());
	}

	public void setBoots(RunsafeMeta itemStack)
	{
		playerInventory.setBoots(itemStack.getRaw());
	}

	public RunsafeMeta getItemInHand()
	{
		return ObjectWrapper.convert(playerInventory.getItemInHand());
	}

	public void setItemInHand(RunsafeMeta itemStack)
	{
		playerInventory.setItemInHand(itemStack.getRaw());
	}

	public int getHeldItemSlot()
	{
		return playerInventory.getHeldItemSlot();
	}

	@Override
	public void clear()
	{
		super.clear();
		playerInventory.setArmorContents(new ItemStack[4]);
	}

	@Override
	public PlayerInventory getRaw()
	{
		return playerInventory;
	}

	protected final PlayerInventory playerInventory;
}
