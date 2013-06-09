package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.item.meta.RunsafeMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class BukkitFirework extends RunsafeMeta
{
	public BukkitFirework(ItemStack stack)
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
