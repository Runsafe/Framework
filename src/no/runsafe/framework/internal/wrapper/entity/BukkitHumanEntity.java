package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryView;
import no.runsafe.framework.minecraft.inventory.RunsafePlayerInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;

public abstract class BukkitHumanEntity extends RunsafeEntity
{
	public BukkitHumanEntity(HumanEntity toWrap)
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

	public RunsafeMeta getItemInHand()
	{
		return ObjectWrapper.convert(this.humanEntity.getItemInHand());
	}

	public void setItemInHand(RunsafeMeta item)
	{
		this.humanEntity.setItemInHand(item.getRaw());
	}

	public RunsafeMeta getItemOnCursor()
	{
		return ObjectWrapper.convert(this.humanEntity.getItemOnCursor());
	}

	public void setItemOnCursor(RunsafeMeta item)
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

	@Override
	public HumanEntity getRaw()
	{
		return humanEntity;
	}

	protected final HumanEntity humanEntity;
}
