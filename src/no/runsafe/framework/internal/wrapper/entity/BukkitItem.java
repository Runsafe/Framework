package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
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
		return ObjectWrapper.convert(this.item.getItemStack());
	}

	public int getPickupDelay()
	{
		return this.item.getPickupDelay();
	}

	public void setItemStack(RunsafeMeta stack)
	{
		this.item.setItemStack(stack.getRaw());
	}

	public void setPickupDelay(int delay)
	{
		this.item.setPickupDelay(delay);
	}

	public Item getRaw()
	{
		return item;
	}

	protected final Item item;
}
