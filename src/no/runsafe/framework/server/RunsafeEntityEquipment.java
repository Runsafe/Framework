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

	public void setItemInHand(RunsafeItemStack itemStack)
	{
		this.entityEquipment.setItemInHand(itemStack.getRaw());
	}

	public RunsafeItemStack getHelmet()
	{
		return ObjectWrapper.convert(this.entityEquipment.getHelmet());
	}

	public void setHelmet(RunsafeItemStack itemStack)
	{
		this.entityEquipment.setHelmet(itemStack.getRaw());
	}

	public RunsafeItemStack getChestplate()
	{
		return ObjectWrapper.convert(this.entityEquipment.getChestplate());
	}

	public void setChestplate(RunsafeItemStack itemStack)
	{
		this.entityEquipment.setChestplate(itemStack.getRaw());
	}

	public RunsafeItemStack getLeggings()
	{
		return ObjectWrapper.convert(this.entityEquipment.getLeggings());
	}

	public void setLeggings(RunsafeItemStack itemStack)
	{
		this.entityEquipment.setLeggings(itemStack.getRaw());
	}

	public RunsafeItemStack getBoots()
	{
		return ObjectWrapper.convert(this.entityEquipment.getBoots());
	}

	public void setBoots(RunsafeItemStack itemStack)
	{
		this.entityEquipment.setBoots(itemStack.getRaw());
	}

	public List<RunsafeItemStack> getArmorContents()
	{
		List<RunsafeItemStack> itemStacks = new ArrayList<RunsafeItemStack>();
		for (ItemStack itemStack : this.entityEquipment.getArmorContents())
			itemStacks.add(new RunsafeItemStack(itemStack));

		return itemStacks;
	}

	public void setArmorContents(List<RunsafeItemStack> itemStacks)
	{
		List<ItemStack> bukkitItemStacks = new ArrayList<ItemStack>();

		for (RunsafeItemStack itemStack : itemStacks)
			bukkitItemStacks.add(itemStack.getRaw());

		this.entityEquipment.setArmorContents((ItemStack[]) bukkitItemStacks.toArray());
	}

	public float getItemInHandDropChance()
	{
		return this.entityEquipment.getItemInHandDropChance();
	}

	public void setItemInHandDropChance(float chance)
	{
		this.entityEquipment.setItemInHandDropChance(chance);
	}

	public float getHelmetDropChance()
	{
		return this.entityEquipment.getHelmetDropChance();
	}

	public void setHelmetDropChance(float chance)
	{
		this.entityEquipment.setHelmetDropChance(chance);
	}

	public float getChestplateDropChance()
	{
		return this.entityEquipment.getChestplateDropChance();
	}

	public void setChestplateDropChance(float chance)
	{
		this.entityEquipment.setChestplateDropChance(chance);
	}

	public float getLeggingsDropChance()
	{
		return this.entityEquipment.getLeggingsDropChance();
	}

	public void setLeggingsDropChance(float chance)
	{
		this.entityEquipment.setLeggingsDropChance(chance);
	}

	public float getBootsDropChance()
	{
		return this.entityEquipment.getBootsDropChance();
	}

	public void setBootsDropChance(float chance)
	{
		this.entityEquipment.setBootsDropChance(chance);
	}

	public void clear()
	{
		this.entityEquipment.clear();
	}

	public RunsafeEntity getHolder()
	{
		return ObjectWrapper.convert(this.entityEquipment.getHolder());
	}

	EntityEquipment entityEquipment;
}
