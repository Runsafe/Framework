package no.runsafe.framework.api.item;

import no.runsafe.framework.exceptions.InvalidDurabilityException;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.material.TexturedMaterial;

import javax.annotation.Nullable;

public enum StoneSlab implements IMaterialData
{
	Any(),
	Smooth(0),
	Sandstone(1),
	Cobblestone(2),
	Brick(3),
	StoneBrick(4),
	NetherRack(5),
	Quartz(6);

	@SuppressWarnings("NumericCastThatLosesPrecision")
	StoneSlab(int durability)
	{
		MaterialData temp = new MaterialData(Material.STEP);
		ItemStack stack = temp.toItemStack();
		if (Material.STEP.getMaxDurability() > durability)
			throw new InvalidDurabilityException(temp.getItemType(), (short) durability);
		stack.setDurability((short) durability);
		data = stack.getData();
	}

	StoneSlab()
	{
		data = null;
	}

	@Override
	public Material getMaterial()
	{
		return Material.STEP;
	}

	@Override
	public boolean isSame(Material material, MaterialData data)
	{
		if (material != Material.STEP || !(data instanceof TexturedMaterial))
			return false;

		return this.data == null || this.data.equals(data);
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
		return "StoneSlab" + (this == Smooth ? "" : Configurable.ID_SEPARATOR + name());
	}

	@Nullable
	private final MaterialData data;

	static void register()
	{
		Configurable.addSimple(values());
	}
}
