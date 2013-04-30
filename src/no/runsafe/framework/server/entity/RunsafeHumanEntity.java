package no.runsafe.framework.server.entity;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.server.inventory.RunsafeInventoryView;
import no.runsafe.framework.server.inventory.RunsafePlayerInventory;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;

public class RunsafeHumanEntity extends RunsafeLivingEntity
{
	public RunsafeHumanEntity(HumanEntity toWrap)
	{
		super(toWrap);
		this.humanEntity = toWrap;
	}

	public String getName()
	{
		return this.humanEntity.getName();
	}

	public RunsafePlayerInventory getInventory()
	{
		return ObjectWrapper.convert(this.humanEntity.getInventory());
	}

	public RunsafeInventory getEnderChest()
	{
		return ObjectWrapper.convert(this.humanEntity.getEnderChest());
	}

	public RunsafeInventoryView getOpenInventory()
	{
		return ObjectWrapper.convert(this.humanEntity.getOpenInventory());
	}

	public RunsafeInventoryView openInventory(RunsafeInventory inventory)
	{
		return ObjectWrapper.convert(this.humanEntity.openInventory(inventory.getRaw()));
	}

	public RunsafeInventoryView openWorkbench(RunsafeLocation location, boolean force)
	{
		return ObjectWrapper.convert(this.humanEntity.openWorkbench(location.getRaw(), force));
	}

	public RunsafeInventoryView openEnchanting(RunsafeLocation location, boolean force)
	{
		return ObjectWrapper.convert(this.humanEntity.openEnchanting(location.getRaw(), force));
	}

	public void openInventory(RunsafeInventoryView inventory)
	{
		this.humanEntity.openInventory(inventory.getRaw());
	}

	public void closeInventory()
	{
		this.humanEntity.closeInventory();
	}

	public RunsafeItemStack getItemInHand()
	{
		return ObjectWrapper.convert(this.humanEntity.getItemInHand());
	}

	public void setItemInHand(RunsafeItemStack item)
	{
		this.humanEntity.setItemInHand(item.getRaw());
	}

	public RunsafeItemStack getItemOnCursor()
	{
		return ObjectWrapper.convert(this.humanEntity.getItemOnCursor());
	}

	public void setItemOnCursor(RunsafeItemStack item)
	{
		this.humanEntity.setItemOnCursor(item.getRaw());
	}

	public boolean isSleeping()
	{
		return this.humanEntity.isSleeping();
	}

	public int getSleepTicks()
	{
		return this.humanEntity.getSleepTicks();
	}

	public GameMode getGameMode()
	{
		return this.humanEntity.getGameMode();
	}

	public void setGameMode(GameMode mode)
	{
		this.humanEntity.setGameMode(mode);
	}

	public boolean isBlocking()
	{
		return this.humanEntity.isBlocking();
	}

	public int getExpToLevel()
	{
		return this.humanEntity.getExpToLevel();
	}

	private HumanEntity humanEntity;
}
