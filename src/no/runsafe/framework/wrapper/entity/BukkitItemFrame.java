package no.runsafe.framework.wrapper.entity;

import no.runsafe.framework.server.entity.RunsafeHanging;
import no.runsafe.framework.server.item.meta.RunsafeMeta;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.entity.ItemFrame;

public abstract class BukkitItemFrame extends RunsafeHanging
{
	public BukkitItemFrame(ItemFrame toWrap)
	{
		super(toWrap);
		itemFrame = toWrap;
	}

	public RunsafeMeta getItem()
	{
		return ObjectWrapper.convert(itemFrame.getItem());
	}

	public void setItem(RunsafeMeta item)
	{
		itemFrame.setItem(item.getRaw());
	}

	@Override
	public ItemFrame getRaw()
	{
		return itemFrame;
	}

	protected final ItemFrame itemFrame;
}
