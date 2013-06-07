package no.runsafe.framework.server.inventory;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.inventory.InventoryView;

public class RunsafeInventoryView
{
	public RunsafeInventoryView(InventoryView toWrap)
	{
		this.inventoryView = toWrap;
	}

	public RunsafePlayer getPlayer()
	{
		return ObjectWrapper.convert(this.inventoryView.getPlayer());
	}

	public void setItem(int slot, RunsafeItemStack item)
	{
		this.inventoryView.setItem(slot, item.getRaw());
	}

	public RunsafeItemStack getItem(int slot)
	{
		return ObjectWrapper.convert(this.inventoryView.getItem(slot));
	}

	public void setCursor(RunsafeItemStack item)
	{
		this.inventoryView.setCursor(item.getRaw());
	}

	public RunsafeItemStack getCursor()
	{
		return ObjectWrapper.convert(this.inventoryView.getCursor());
	}

	public int convertSlot(int rawSlot)
	{
		return this.inventoryView.convertSlot(rawSlot);
	}

	public void close()
	{
		this.inventoryView.close();
	}

	public int countSlots()
	{
		return this.inventoryView.countSlots();
	}

	public String getTitle()
	{
		return this.inventoryView.getTitle();
	}

	public InventoryView getRaw()
	{
		return this.inventoryView;
	}

	public RunsafeInventoryType getType()
	{
		return ObjectWrapper.convert(this.inventoryView.getType());
	}

	private final InventoryView inventoryView;
}
