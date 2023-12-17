package no.runsafe.framework.internal.wrapper.item.meta;

import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public abstract class BukkitLeatherArmor extends RunsafeMeta
{
	protected BukkitLeatherArmor(ItemStack stack)
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

	public void setColor(int red, int green, int blue)
	{
		LeatherArmorMeta meta = getRawMeta();
		meta.setColor(Color.fromRGB(red, green, blue));
		itemStack.setItemMeta(meta);
	}
}
