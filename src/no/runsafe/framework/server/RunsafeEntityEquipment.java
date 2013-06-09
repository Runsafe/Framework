package no.runsafe.framework.server;

import no.runsafe.framework.server.item.meta.RunsafeMeta;
import no.runsafe.framework.wrapper.inventory.BukkitEntityEquipment;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RunsafeEntityEquipment extends BukkitEntityEquipment
{
	public RunsafeEntityEquipment(EntityEquipment toWrap)
	{
		super(toWrap);
	}

	public RunsafeEntityEquipment setItemInHand(RunsafeMeta itemStack)
	{
		this.entityEquipment.setItemInHand(itemStack.getRaw());
		return this;
	}

	public RunsafeEntityEquipment setHelmet(RunsafeMeta itemStack)
	{
		this.entityEquipment.setHelmet(itemStack.getRaw());
		return this;
	}

	public RunsafeEntityEquipment setChestplate(RunsafeMeta itemStack)
	{
		this.entityEquipment.setChestplate(itemStack.getRaw());
		return this;
	}

	public RunsafeEntityEquipment setLeggings(RunsafeMeta itemStack)
	{
		this.entityEquipment.setLeggings(itemStack.getRaw());
		return this;
	}

	public RunsafeEntityEquipment setBoots(RunsafeMeta itemStack)
	{
		this.entityEquipment.setBoots(itemStack.getRaw());
		return this;
	}

	public RunsafeEntityEquipment setArmorContents(List<RunsafeMeta> itemStacks)
	{
		List<ItemStack> bukkitItemStacks = new ArrayList<ItemStack>();
		for (RunsafeMeta itemStack : itemStacks)
			bukkitItemStacks.add(itemStack.getRaw());
		this.entityEquipment.setArmorContents((ItemStack[]) bukkitItemStacks.toArray());
		return this;
	}

	public RunsafeEntityEquipment setItemInHandDropChance(float chance)
	{
		this.entityEquipment.setItemInHandDropChance(chance);
		return this;
	}

	public RunsafeEntityEquipment setHelmetDropChance(float chance)
	{
		this.entityEquipment.setHelmetDropChance(chance);
		return this;
	}

	public RunsafeEntityEquipment setChestplateDropChance(float chance)
	{
		this.entityEquipment.setChestplateDropChance(chance);
		return this;
	}

	public RunsafeEntityEquipment setLeggingsDropChance(float chance)
	{
		this.entityEquipment.setLeggingsDropChance(chance);
		return this;
	}

	public RunsafeEntityEquipment setBootsDropChance(float chance)
	{
		this.entityEquipment.setBootsDropChance(chance);
		return this;
	}
}
