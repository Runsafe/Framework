package no.runsafe.framework.wrapper.inventory;

import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.inventory.EntityEquipment;

import java.util.List;

public class BukkitEntityEquipment
{
	public BukkitEntityEquipment(EntityEquipment toWrap)
	{
		entityEquipment = toWrap;
	}

	public RunsafeItemStack getItemInHand()
	{
		return ObjectWrapper.convert(this.entityEquipment.getItemInHand());
	}

	public RunsafeItemStack getHelmet()
	{
		return ObjectWrapper.convert(this.entityEquipment.getHelmet());
	}

	public RunsafeItemStack getChestplate()
	{
		return ObjectWrapper.convert(this.entityEquipment.getChestplate());
	}

	public RunsafeItemStack getLeggings()
	{
		return ObjectWrapper.convert(this.entityEquipment.getLeggings());
	}

	public RunsafeItemStack getBoots()
	{
		return ObjectWrapper.convert(this.entityEquipment.getBoots());
	}

	public List<RunsafeItemStack> getArmorContents()
	{
		return ObjectWrapper.convert(entityEquipment.getArmorContents());
	}

	public float getItemInHandDropChance()
	{
		return this.entityEquipment.getItemInHandDropChance();
	}

	public float getHelmetDropChance()
	{
		return this.entityEquipment.getHelmetDropChance();
	}

	public float getChestplateDropChance()
	{
		return this.entityEquipment.getChestplateDropChance();
	}

	public float getLeggingsDropChance()
	{
		return this.entityEquipment.getLeggingsDropChance();
	}

	public float getBootsDropChance()
	{
		return this.entityEquipment.getBootsDropChance();
	}

	public void clear()
	{
		this.entityEquipment.clear();
	}

	public RunsafeEntity getHolder()
	{
		return ObjectWrapper.convert(this.entityEquipment.getHolder());
	}

	protected final EntityEquipment entityEquipment;
}
