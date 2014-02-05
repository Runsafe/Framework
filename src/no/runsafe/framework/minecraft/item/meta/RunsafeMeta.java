package no.runsafe.framework.minecraft.item.meta;

import no.runsafe.framework.internal.wrapper.IWrapper;
import no.runsafe.framework.internal.wrapper.item.meta.BukkitMeta;
import org.bukkit.inventory.ItemStack;

public class RunsafeMeta extends BukkitMeta implements IWrapper<ItemStack>
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
