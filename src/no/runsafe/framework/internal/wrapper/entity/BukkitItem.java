package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.internal.wrapper.IWrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.entity.Item;

public abstract class BukkitItem extends RunsafeEntity
{
	protected BukkitItem(Item toWrap)
	{
		super(toWrap);
		item = toWrap;
	}

	public RunsafeMeta getItemStack()
	{
		return ObjectWrapper.convert(item.getItemStack());
	}

	public int getPickupDelay()
	{
		return item.getPickupDelay();
	}

	public void setItemStack(RunsafeMeta stack)
	{
		item.setItemStack(stack.getRaw());
	}

	public void setPickupDelay(int delay)
	{
		item.setPickupDelay(delay);
	}

	@Override
	public Item getRaw()
	{
		return item;
	}

	protected final Item item;
}
