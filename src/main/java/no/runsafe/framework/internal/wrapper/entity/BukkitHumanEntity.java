package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.minecraft.IAnimalTamer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryView;
import no.runsafe.framework.minecraft.inventory.RunsafePlayerInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;

public abstract class BukkitHumanEntity extends RunsafeEntity implements IAnimalTamer
{
	protected BukkitHumanEntity(HumanEntity toWrap)
	{
		super(toWrap);
		humanEntity = toWrap;
	}

	@Override
	public String getName()
	{
		return humanEntity.getName();
	}

	public RunsafePlayerInventory getInventory()
	{
		return ObjectWrapper.convert(humanEntity.getInventory());
	}

	public RunsafeInventory getEnderChest()
	{
		return ObjectWrapper.convert(humanEntity.getEnderChest());
	}

	public RunsafeInventoryView getOpenInventory()
	{
		return ObjectWrapper.convert(humanEntity.getOpenInventory());
	}

	public RunsafeInventoryView openInventory(RunsafeInventory inventory)
	{
		return ObjectWrapper.convert(humanEntity.openInventory(inventory.getRaw()));
	}

	public RunsafeInventoryView openWorkbench(ILocation location, boolean force)
	{
		return ObjectWrapper.convert(humanEntity.openWorkbench((Location) ObjectUnwrapper.convert(location), force));
	}

	public RunsafeInventoryView openEnchanting(ILocation location, boolean force)
	{
		return ObjectWrapper.convert(humanEntity.openEnchanting((Location) ObjectUnwrapper.convert(location), force));
	}

	public void openInventory(RunsafeInventoryView inventory)
	{
		humanEntity.openInventory(inventory.getRaw());
	}

	public void closeInventory()
	{
		humanEntity.closeInventory();
	}

	public RunsafeMeta getItemInHand()
	{
		return ObjectWrapper.convert(humanEntity.getItemInHand());
	}

	public void setItemInHand(RunsafeMeta item)
	{
		humanEntity.setItemInHand(item.getRaw());
	}

	public RunsafeMeta getItemOnCursor()
	{
		return ObjectWrapper.convert(humanEntity.getItemOnCursor());
	}

	public void setItemOnCursor(RunsafeMeta item)
	{
		humanEntity.setItemOnCursor(item.getRaw());
	}

	public boolean isSleeping()
	{
		return humanEntity.isSleeping();
	}

	public int getSleepTicks()
	{
		return humanEntity.getSleepTicks();
	}

	public GameMode getGameMode()
	{
		return humanEntity.getGameMode();
	}

	public void setGameMode(GameMode mode)
	{
		humanEntity.setGameMode(mode);
	}

	public boolean isBlocking()
	{
		return humanEntity.isBlocking();
	}

	public int getExpToLevel()
	{
		return humanEntity.getExpToLevel();
	}

	@Override
	public HumanEntity getRaw()
	{
		return humanEntity;
	}

	protected final HumanEntity humanEntity;
}
