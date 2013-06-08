package no.runsafe.framework.wrapper.entity;

import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.entity.Item;

public abstract class BukkitItem extends RunsafeEntity
{
	public BukkitItem(Item toWrap)
	{
		super(toWrap);
		item = toWrap;
	}

	public RunsafeItemStack getItemStack()
	{
		return ObjectWrapper.convert(this.item.getItemStack());
	}

	public int getPickupDelay()
	{
		return this.item.getPickupDelay();
	}

	public void setItemStack(RunsafeItemStack stack)
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
