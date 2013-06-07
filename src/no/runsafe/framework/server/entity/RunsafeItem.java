package no.runsafe.framework.server.entity;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.entity.Item;

public class RunsafeItem extends RunsafeEntity
{
	public RunsafeItem(Item toWrap)
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
	
	private final Item item;
}
