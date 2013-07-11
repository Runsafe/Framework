package no.runsafe.framework.minecraft.event.inventory;

import no.runsafe.framework.api.event.CancellableEvent;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class RunsafeInventoryClickEvent extends RunsafeInventoryEvent implements CancellableEvent
{
	public RunsafeInventoryClickEvent(InventoryClickEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	public InventoryType.SlotType getSlotType()
	{
		return this.event.getSlotType();
	}

	public RunsafeMeta getCursor()
	{
		return ObjectWrapper.convert(this.event.getCursor());
	}

	public RunsafePlayer getWhoClicked()
	{
		return ObjectWrapper.convert(this.event.getWhoClicked());
	}

	public RunsafeMeta getCurrentItem()
	{
		return ObjectWrapper.convert(this.event.getCurrentItem());
	}

	public boolean isRightClick()
	{
		return this.event.isRightClick();
	}

	public boolean isLeftClick()
	{
		return this.event.isLeftClick();
	}

	public boolean isShiftClick()
	{
		return this.event.isShiftClick();
	}

	@Deprecated
	public void setCursor(RunsafeMeta what)
	{
		this.event.setCursor(what.getRaw());
	}

	public void setCurrentItem(RunsafeMeta what)
	{
		this.event.setCurrentItem(what.getRaw());
	}

	public int getSlot()
	{
		return this.event.getSlot();
	}

	public int getRawSlot()
	{
		return this.event.getRawSlot();
	}

	@Override
	public boolean getCancelled()
	{
		return this.event.isCancelled();
	}

	@Override
	public void setCancelled(boolean cancel)
	{
		this.event.setCancelled(cancel);
	}

	private final InventoryClickEvent event;
}
