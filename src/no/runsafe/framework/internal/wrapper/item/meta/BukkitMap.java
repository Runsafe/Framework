package no.runsafe.framework.internal.wrapper.item.meta;

import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;

public abstract class BukkitMap extends RunsafeMeta
{
	public BukkitMap(ItemStack stack)
	{
		super(stack);
	}

	@Override
	public MapMeta getRawMeta()
	{
		return (MapMeta) itemStack.getItemMeta();
	}

	public boolean isScaling()
	{
		return getRawMeta().isScaling();
	}

	public void setScaling(boolean value)
	{
		MapMeta meta = getRawMeta();
		meta.setScaling(value);
		itemStack.setItemMeta(meta);
	}
}
