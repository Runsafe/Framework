package no.runsafe.framework.internal.wrapper.inventory;

import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.inventory.EntityEquipment;

import java.util.List;

public abstract class BukkitEntityEquipment
{
	protected BukkitEntityEquipment(EntityEquipment toWrap)
	{
		entityEquipment = toWrap;
	}

	public RunsafeMeta getItemInHand()
	{
		return ObjectWrapper.convert(entityEquipment.getItemInHand());
	}

	public RunsafeMeta getHelmet()
	{
		return ObjectWrapper.convert(entityEquipment.getHelmet());
	}

	public RunsafeMeta getChestplate()
	{
		return ObjectWrapper.convert(entityEquipment.getChestplate());
	}

	public RunsafeMeta getLeggings()
	{
		return ObjectWrapper.convert(entityEquipment.getLeggings());
	}

	public RunsafeMeta getBoots()
	{
		return ObjectWrapper.convert(entityEquipment.getBoots());
	}

	public List<RunsafeMeta> getArmorContents()
	{
		return ObjectWrapper.convert(entityEquipment.getArmorContents());
	}

	public float getItemInHandDropChance()
	{
		return entityEquipment.getItemInHandDropChance();
	}

	public float getHelmetDropChance()
	{
		return entityEquipment.getHelmetDropChance();
	}

	public float getChestplateDropChance()
	{
		return entityEquipment.getChestplateDropChance();
	}

	public float getLeggingsDropChance()
	{
		return entityEquipment.getLeggingsDropChance();
	}

	public float getBootsDropChance()
	{
		return entityEquipment.getBootsDropChance();
	}

	public void clear()
	{
		entityEquipment.clear();
	}

	public RunsafeEntity getHolder()
	{
		return ObjectWrapper.convert(entityEquipment.getHolder());
	}

	public EntityEquipment getRaw()
	{
		return entityEquipment;
	}

	protected final EntityEquipment entityEquipment;
}
