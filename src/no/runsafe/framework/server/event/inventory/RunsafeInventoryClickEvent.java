package no.runsafe.framework.server.event.inventory;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.server.player.RunsafePlayer;
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

	public RunsafeItemStack getCursor()
	{
		return ObjectWrapper.convert(this.event.getCursor());
	}

	public RunsafePlayer getWhoClicked()
	{
		return ObjectWrapper.convert(this.event.getWhoClicked());
	}

	public RunsafeItemStack getCurrentItem()
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

	public void setCursor(RunsafeItemStack what)
	{
		this.event.setCursor(what.getRaw());
	}

	public void setCurrentItem(RunsafeItemStack what)
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

	private InventoryClickEvent event;
}
