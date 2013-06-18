package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.minecraft.entity.RunsafeHanging;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.entity.ItemFrame;

public abstract class BukkitItemFrame extends RunsafeHanging
{
	protected BukkitItemFrame(ItemFrame toWrap)
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
