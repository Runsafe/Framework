package no.runsafe.framework.server;

import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RunsafeEntityEquipment
{
	public RunsafeEntityEquipment(EntityEquipment toWrap)
	{
		entityEquipment = toWrap;
	}

	public RunsafeItemStack getItemInHand()
	{
		return ObjectWrapper.convert(this.entityEquipment.getItemInHand());
	}

	public RunsafeEntityEquipment setItemInHand(RunsafeItemStack itemStack)
	{
		this.entityEquipment.setItemInHand(itemStack.getRaw());
		return this;
	}

	public RunsafeItemStack getHelmet()
	{
		return ObjectWrapper.convert(this.entityEquipment.getHelmet());
	}

	public RunsafeEntityEquipment setHelmet(RunsafeItemStack itemStack)
	{
		this.entityEquipment.setHelmet(itemStack.getRaw());
		return this;
	}

	public RunsafeItemStack getChestplate()
	{
		return ObjectWrapper.convert(this.entityEquipment.getChestplate());
	}

	public RunsafeEntityEquipment setChestplate(RunsafeItemStack itemStack)
	{
		this.entityEquipment.setChestplate(itemStack.getRaw());
		return this;
	}

	public RunsafeItemStack getLeggings()
	{
		return ObjectWrapper.convert(this.entityEquipment.getLeggings());
	}

	public RunsafeEntityEquipment setLeggings(RunsafeItemStack itemStack)
	{
		this.entityEquipment.setLeggings(itemStack.getRaw());
		return this;
	}

	public RunsafeItemStack getBoots()
	{
		return ObjectWrapper.convert(this.entityEquipment.getBoots());
	}

	public RunsafeEntityEquipment setBoots(RunsafeItemStack itemStack)
	{
		this.entityEquipment.setBoots(itemStack.getRaw());
		return this;
	}

	public List<RunsafeItemStack> getArmorContents()
	{
		List<RunsafeItemStack> itemStacks = new ArrayList<RunsafeItemStack>();
		for (ItemStack itemStack : this.entityEquipment.getArmorContents())
			itemStacks.add(new RunsafeItemStack(itemStack));

		return itemStacks;
	}

	public RunsafeEntityEquipment setArmorContents(List<RunsafeItemStack> itemStacks)
	{
		List<ItemStack> bukkitItemStacks = new ArrayList<ItemStack>();

		for (RunsafeItemStack itemStack : itemStacks)
			bukkitItemStacks.add(itemStack.getRaw());

		this.entityEquipment.setArmorContents((ItemStack[]) bukkitItemStacks.toArray());
		return this;
	}

	public float getItemInHandDropChance()
	{
		return this.entityEquipment.getItemInHandDropChance();
	}

	public RunsafeEntityEquipment setItemInHandDropChance(float chance)
	{
		this.entityEquipment.setItemInHandDropChance(chance);
		return this;
	}

	public float getHelmetDropChance()
	{
		return this.entityEquipment.getHelmetDropChance();
	}

	public RunsafeEntityEquipment setHelmetDropChance(float chance)
	{
		this.entityEquipment.setHelmetDropChance(chance);
		return this;
	}

	public float getChestplateDropChance()
	{
		return this.entityEquipment.getChestplateDropChance();
	}

	public RunsafeEntityEquipment setChestplateDropChance(float chance)
	{
		this.entityEquipment.setChestplateDropChance(chance);
		return this;
	}

	public float getLeggingsDropChance()
	{
		return this.entityEquipment.getLeggingsDropChance();
	}

	public RunsafeEntityEquipment setLeggingsDropChance(float chance)
	{
		this.entityEquipment.setLeggingsDropChance(chance);
		return this;
	}

	public float getBootsDropChance()
	{
		return this.entityEquipment.getBootsDropChance();
	}

	public RunsafeEntityEquipment setBootsDropChance(float chance)
	{
		this.entityEquipment.setBootsDropChance(chance);
		return this;
	}

	public void clear()
	{
		this.entityEquipment.clear();
	}

	public RunsafeEntity getHolder()
	{
		return ObjectWrapper.convert(this.entityEquipment.getHolder());
	}

	final EntityEquipment entityEquipment;
}
