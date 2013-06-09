package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.item.meta.RunsafeMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;

public abstract class BukkitPotion extends RunsafeMeta
{
	public BukkitPotion(ItemStack stack)
	{
		super(stack);
	}

	@Override
	public PotionMeta getRawMeta()
	{
		return (PotionMeta) itemStack.getItemMeta();
	}

	public boolean hasCustomEffects()
	{
		return getRawMeta().hasCustomEffects();
	}

	public boolean clearCustomEffects()
	{
		PotionMeta meta = getRawMeta();
		boolean success = meta.clearCustomEffects();
		if(success)
			itemStack.setItemMeta(meta);
		return success;
	}
}
