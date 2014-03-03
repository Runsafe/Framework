package no.runsafe.framework.minecraft.item.meta;

import no.runsafe.framework.internal.wrapper.item.meta.BukkitMeta;
import org.bukkit.inventory.ItemStack;

public class RunsafeMeta extends BukkitMeta
{
	public RunsafeMeta(ItemStack stack)
	{
		super(stack);
	}

	@Override
	public RunsafeMeta getItem()
	{
		return this;
	}
}
