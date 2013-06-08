package no.runsafe.framework.server.item;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class RunsafeFirework extends RunsafeItemStack
{
	public RunsafeFirework(ItemStack stack)
	{
		super(stack);
	}

	public RunsafeFirework setPower(int power)
	{
		FireworkMeta meta = (FireworkMeta) itemStack.getItemMeta();
		meta.setPower(power);
		itemStack.setItemMeta(meta);
		return this;
	}
}
