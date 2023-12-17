package no.runsafe.framework.api.item;

import no.runsafe.framework.exceptions.InvalidDurabilityException;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.material.SmoothBrick;

import javax.annotation.Nullable;

public enum StoneBrick implements IMaterialData
{
	Any(),
	Normal(0),
	Mossy(1),
	Cracked(2),
	Chiseled(3);

	@SuppressWarnings("NumericCastThatLosesPrecision")
	StoneBrick(int durability)
	{
		MaterialData temp = new MaterialData(Material.SMOOTH_BRICK);
		ItemStack stack = temp.toItemStack();
		if (Material.SMOOTH_BRICK.getMaxDurability() > durability)
			throw new InvalidDurabilityException(temp.getItemType(), (short) durability);
		stack.setDurability((short) durability);
		data = stack.getData();
	}

	StoneBrick()
	{
		data = null;
	}

	@Override
	public Material getMaterial()
	{
		return Material.SMOOTH_BRICK;
	}

	@Override
	public boolean isSame(Material material, MaterialData data)
	{
		if (material != Material.SMOOTH_BRICK || !(data instanceof SmoothBrick))
			return false;

		return this.data == null || data.equals(this.data);
	}

	@Nullable
	@Override
	public MaterialData getData()
	{
		return data;
	}

	@Override
	public String getName()
	{
		return "StoneBrick" + (this == Normal ? "" : Configurable.ID_SEPARATOR + name());
	}

	@Nullable
	private final MaterialData data;

	static void register()
	{
		Configurable.addSimple(values());
	}
}
