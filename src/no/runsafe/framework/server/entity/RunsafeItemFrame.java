package no.runsafe.framework.server.entity;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.entity.ItemFrame;

public class RunsafeItemFrame extends RunsafeHanging
{
	public RunsafeItemFrame(ItemFrame toWrap)
	{
		super(toWrap);
		itemFrame = toWrap;
	}

	public RunsafeItemStack getItem()
	{
		return ObjectWrapper.convert(itemFrame.getItem());
	}

	public void setItem(RunsafeItemStack item)
	{
		itemFrame.setItem(item.getRaw());
	}

	private final ItemFrame itemFrame;
}
