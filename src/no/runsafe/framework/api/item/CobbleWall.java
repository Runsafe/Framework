package no.runsafe.framework.api.item;

import no.runsafe.framework.exceptions.InvalidDurabilityException;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.material.TexturedMaterial;

import javax.annotation.Nullable;

public enum CobbleWall implements IMaterial, IMaterialData
{
	Any(),
	Normal(0),
	Mossy(1);

	@SuppressWarnings("NumericCastThatLosesPrecision")
	CobbleWall(int durability)
	{
		MaterialData temp = new MaterialData(Material.COBBLE_WALL);
		ItemStack stack = temp.toItemStack();
		if (Material.COBBLE_WALL.getMaxDurability() > durability)
			throw new InvalidDurabilityException(temp.getItemType(), (short) durability);
		stack.setDurability((short) durability);
		data = stack.getData();
	}

	CobbleWall()
	{
		data = null;
	}

	@Override
	public Material getMaterial()
	{
		return Material.COBBLE_WALL;
	}

	@Override
	public boolean isSame(Material material, MaterialData data)
	{
		if (material != Material.COBBLE_WALL || !(data instanceof TexturedMaterial))
			return false;

		return this.data == null || this.data.equals(data);
	}

	@Override
	public MaterialData getData()
	{
		return data;
	}

	@Nullable
	private final MaterialData data;
}
