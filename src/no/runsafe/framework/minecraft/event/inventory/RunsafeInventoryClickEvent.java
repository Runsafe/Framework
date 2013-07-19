package no.runsafe.framework.minecraft.event.inventory;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class RunsafeInventoryClickEvent extends RunsafeCancellableInventoryEvent
{
	public RunsafeInventoryClickEvent(InventoryClickEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public InventoryType.SlotType getSlotType()
	{
		return event.getSlotType();
	}

	public RunsafeMeta getCursor()
	{
		return ObjectWrapper.convert(event.getCursor());
	}

	public RunsafePlayer getWhoClicked()
	{
		return ObjectWrapper.convert(event.getWhoClicked());
	}

	public RunsafeMeta getCurrentItem()
	{
		return ObjectWrapper.convert(event.getCurrentItem());
	}

	public boolean isRightClick()
	{
		return event.isRightClick();
	}

	public boolean isLeftClick()
	{
		return event.isLeftClick();
	}

	public boolean isShiftClick()
	{
		return event.isShiftClick();
	}

	public void setCurrentItem(RunsafeMeta what)
	{
		event.setCurrentItem(what.getRaw());
	}

	public int getSlot()
	{
		return event.getSlot();
	}

	public int getRawSlot()
	{
		return event.getRawSlot();
	}

	private final InventoryClickEvent event;
}
