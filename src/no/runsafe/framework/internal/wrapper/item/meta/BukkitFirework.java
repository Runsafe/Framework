package no.runsafe.framework.internal.wrapper.item.meta;

import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class BukkitFirework extends RunsafeMeta
{
	protected BukkitFirework(ItemStack stack)
	{
		super(stack);
	}

	public BukkitFirework setPower(int power)
	{
		FireworkMeta meta = (FireworkMeta) itemStack.getItemMeta();
		meta.setPower(power);
		itemStack.setItemMeta(meta);
		return this;
	}
}
