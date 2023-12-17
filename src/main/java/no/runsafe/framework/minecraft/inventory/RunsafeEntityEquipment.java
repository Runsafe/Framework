package no.runsafe.framework.minecraft.inventory;

import no.runsafe.framework.internal.wrapper.inventory.BukkitEntityEquipment;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

public class RunsafeEntityEquipment extends BukkitEntityEquipment
{
	public RunsafeEntityEquipment(EntityEquipment toWrap)
	{
		super(toWrap);
	}

	public RunsafeEntityEquipment setItemInHand(RunsafeMeta itemStack)
	{
		entityEquipment.setItemInHand(itemStack.getRaw());
		return this;
	}

	public RunsafeEntityEquipment setHelmet(RunsafeMeta itemStack)
	{
		entityEquipment.setHelmet(itemStack.getRaw());
		return this;
	}

	public RunsafeEntityEquipment setChestplate(RunsafeMeta itemStack)
	{
		entityEquipment.setChestplate(itemStack.getRaw());
		return this;
	}

	public RunsafeEntityEquipment setLeggings(RunsafeMeta itemStack)
	{
		entityEquipment.setLeggings(itemStack.getRaw());
		return this;
	}

	public RunsafeEntityEquipment setBoots(RunsafeMeta itemStack)
	{
		entityEquipment.setBoots(itemStack.getRaw());
		return this;
	}

	public RunsafeEntityEquipment setArmorContents(Iterable<RunsafeMeta> itemStacks)
	{
		Collection<ItemStack> bukkitItemStacks = new ArrayList<ItemStack>(4);
		for (RunsafeMeta itemStack : itemStacks)
			bukkitItemStacks.add(itemStack.getRaw());
		entityEquipment.setArmorContents(bukkitItemStacks.toArray(new ItemStack[bukkitItemStacks.size()]));
		return this;
	}

	public RunsafeEntityEquipment setItemInHandDropChance(float chance)
	{
		entityEquipment.setItemInHandDropChance(chance);
		return this;
	}

	public RunsafeEntityEquipment setHelmetDropChance(float chance)
	{
		entityEquipment.setHelmetDropChance(chance);
		return this;
	}

	public RunsafeEntityEquipment setChestplateDropChance(float chance)
	{
		entityEquipment.setChestplateDropChance(chance);
		return this;
	}

	public RunsafeEntityEquipment setLeggingsDropChance(float chance)
	{
		entityEquipment.setLeggingsDropChance(chance);
		return this;
	}

	public RunsafeEntityEquipment setBootsDropChance(float chance)
	{
		entityEquipment.setBootsDropChance(chance);
		return this;
	}
}
