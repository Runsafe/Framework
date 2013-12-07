package no.runsafe.framework.internal.wrapper.inventory;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryType;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.inventory.InventoryView;

public abstract class BukkitInventoryView
{
	protected BukkitInventoryView(InventoryView toWrap)
	{
		inventoryView = toWrap;
	}

	public IPlayer getPlayer()
	{
		return ObjectWrapper.convert(inventoryView.getPlayer());
	}

	public void setItem(int slot, RunsafeMeta item)
	{
		inventoryView.setItem(slot, item.getRaw());
	}

	public RunsafeMeta getItem(int slot)
	{
		return ObjectWrapper.convert(inventoryView.getItem(slot));
	}

	public void setCursor(RunsafeMeta item)
	{
		inventoryView.setCursor(item.getRaw());
	}

	public RunsafeMeta getCursor()
	{
		return ObjectWrapper.convert(inventoryView.getCursor());
	}

	public int convertSlot(int rawSlot)
	{
		return inventoryView.convertSlot(rawSlot);
	}

	public void close()
	{
		inventoryView.close();
	}

	public int countSlots()
	{
		return inventoryView.countSlots();
	}

	public String getTitle()
	{
		return inventoryView.getTitle();
	}

	public InventoryView getRaw()
	{
		return inventoryView;
	}

	public RunsafeInventoryType getType()
	{
		return ObjectWrapper.convert(inventoryView.getType());
	}

	protected final InventoryView inventoryView;
}
