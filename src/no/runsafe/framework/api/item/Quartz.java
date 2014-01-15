package no.runsafe.framework.api.item;

import no.runsafe.framework.exceptions.InvalidDurabilityException;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import javax.annotation.Nullable;

public enum Quartz implements IMaterialData
{
	Any(),
	Normal(0),
	Chiseled(1),
	Pillar(2);

	@SuppressWarnings("NumericCastThatLosesPrecision")
	Quartz(int durability)
	{
		MaterialData temp = new MaterialData(Material.QUARTZ_BLOCK);
		ItemStack stack = temp.toItemStack();
		if (Material.QUARTZ_BLOCK.getMaxDurability() > durability)
			throw new InvalidDurabilityException(temp.getItemType(), (short) durability);
		stack.setDurability((short) durability);
		data = stack.getData();
	}

	Quartz()
	{
		data = null;
	}

	@Override
	public Material getMaterial()
	{
		return Material.QUARTZ_BLOCK;
	}

	@Nullable
	@Override
	public MaterialData getData()
	{
		return data;
	}

	@Override
	public boolean isSame(Material material, MaterialData data)
	{
		return material == Material.QUARTZ_BLOCK && (this.data == null || data.equals(this.data));
	}

	@Nullable
	private final MaterialData data;

	@Override
	public String getName()
	{
		return "QuartzBlock" + (this == Normal ? "" : Configurable.ID_SEPARATOR + name());
	}

	static void register()
	{
		Configurable.addSimple(values());
	}
}
