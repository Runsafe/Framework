package no.runsafe.framework.internal.wrapper.item.meta;

import no.runsafe.framework.minecraft.Buff;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;

public abstract class BukkitPotion extends RunsafeMeta
{
	protected BukkitPotion(ItemStack stack)
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

	public void giveCustomEffect(Buff effect)
	{
		if (effect == null)
			return;

		getRawMeta().addCustomEffect(effect.getEffect(), true);
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
