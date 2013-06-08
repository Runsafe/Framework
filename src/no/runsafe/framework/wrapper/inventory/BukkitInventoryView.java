package no.runsafe.framework.wrapper.inventory;

import no.runsafe.framework.server.inventory.RunsafeInventoryType;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.inventory.InventoryView;

public abstract class BukkitInventoryView
{
	public BukkitInventoryView(InventoryView toWrap)
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

	protected final InventoryView inventoryView;
}
