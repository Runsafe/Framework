package no.runsafe.framework.wrapper.inventory;

import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.item.meta.RunsafeMeta;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.inventory.EntityEquipment;

import java.util.List;

public abstract class BukkitEntityEquipment
{
	public BukkitEntityEquipment(EntityEquipment toWrap)
	{
		entityEquipment = toWrap;
	}

	public RunsafeMeta getItemInHand()
	{
		return ObjectWrapper.convert(this.entityEquipment.getItemInHand());
	}

	public RunsafeMeta getHelmet()
	{
		return ObjectWrapper.convert(this.entityEquipment.getHelmet());
	}

	public RunsafeMeta getChestplate()
	{
		return ObjectWrapper.convert(this.entityEquipment.getChestplate());
	}

	public RunsafeMeta getLeggings()
	{
		return ObjectWrapper.convert(this.entityEquipment.getLeggings());
	}

	public RunsafeMeta getBoots()
	{
		return ObjectWrapper.convert(this.entityEquipment.getBoots());
	}

	public List<RunsafeMeta> getArmorContents()
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

	public EntityEquipment getRaw()
	{
		return entityEquipment;
	}

	protected final EntityEquipment entityEquipment;
}
