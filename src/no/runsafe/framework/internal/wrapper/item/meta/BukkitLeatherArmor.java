package no.runsafe.framework.internal.wrapper.item.meta;

import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public abstract class BukkitLeatherArmor extends RunsafeMeta
{
	public BukkitLeatherArmor(ItemStack stack)
	{
		super(stack);
	}

	@Override
	public LeatherArmorMeta getRawMeta()
	{
		return (LeatherArmorMeta) itemStack.getItemMeta();
	}

	public int getColor()
	{
		return getRawMeta().getColor().asRGB();
	}

	public void setColor(int color)
	{
		LeatherArmorMeta meta = getRawMeta();
		meta.setColor(Color.fromRGB(color));
		itemStack.setItemMeta(meta);
	}

	public void setColor(int r, int g, int b)
	{
		LeatherArmorMeta meta = getRawMeta();
		meta.setColor(Color.fromRGB(r, g, b));
		itemStack.setItemMeta(meta);
	}
}
